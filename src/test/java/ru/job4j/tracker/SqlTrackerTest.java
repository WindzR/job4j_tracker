package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void whenAddItemAndFindByName() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "Ivan");
            tracker.add(item);
            List<Item> rsl = tracker.findByName("Ivan");
            assertThat(rsl.get(0).getName(), is(item.getName()));
        }
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "Ivan");
            tracker.add(item);
            List<Item> rsl = tracker.findByName("Ivan");
            assertThat(rsl.get(0).getName(), is("Ivan"));
            int id = item.getId();
            tracker.delete(id);
            assertNull(tracker.findById(id));
        }
    }

    @Test
    public void whenFindAll() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "Ivan");
            Item item2 = new Item(2, "Oleg");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> rsl = tracker.findAll();
            assertThat(rsl.size(), is(2));
            assertThat(rsl.get(0).getName(), is("Ivan"));
            assertThat(rsl.get(1).getName(), is("Oleg"));
        }
    }

    @Test
    public void whenFindById() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "Ivan");
            tracker.add(item);
            Item rsl = tracker.findById(item.getId());
            assertThat(rsl.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenUpdate() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "Ivan");
            tracker.add(item);
            Item check = tracker.findById(item.getId());
            assertThat(check.getName(), is("Ivan"));
            Item update = new Item(2, "Oleg");
            assertTrue(tracker.replace(item.getId(), update));
            List<Item> rsl = tracker.findByName(update.getName());
            assertThat(rsl.size(), is(1));
            assertThat(rsl.get(0).getName(), is(update.getName()));
        }
    }
}