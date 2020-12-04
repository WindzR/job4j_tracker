package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findByAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. ==== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction(out)
        };
        Item item1 = new Item();
        item1.setName("item 1");
        tracker.add(item1);
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. ==== List of Items ====" + System.lineSeparator() +
                "1. ==== Exit ====" + System.lineSeparator() +
                item1.toString() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. ==== List of Items ====" + System.lineSeparator() +
                "1. ==== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindId() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        Item item1 = new Item();
        item1.setName("item name");
        tracker.add(item1);
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. ==== Find by Id ====" + System.lineSeparator() +
                "1. ==== Exit ====" + System.lineSeparator() +
                "==== Item ====" + System.lineSeparator() +
                item1.toString() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. ==== Find by Id ====" + System.lineSeparator() +
                "1. ==== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "item name", "1" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        Item item1 = new Item();
        item1.setName("item name");
        tracker.add(item1);
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. ==== Find by name ====" + System.lineSeparator() +
                "1. ==== Exit ====" + System.lineSeparator() +
                 "==== Item ====" + System.lineSeparator() +
                 item1.toString() + System.lineSeparator() +
                 "Menu." + System.lineSeparator() +
                 "0. ==== Find by name ====" + System.lineSeparator() +
                 "1. ==== Exit ====" + System.lineSeparator()
        ));
    }
}