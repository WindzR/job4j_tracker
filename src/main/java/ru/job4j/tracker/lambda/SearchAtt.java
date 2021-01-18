package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
       Predicate<Attachment> predicate = new Predicate<Attachment>() {
           @Override
           public boolean test(Attachment attachment) {
               return attachment.getSize() > 100;
           }
       };
       return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> filterFunc) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (filterFunc.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
