package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
//    public static List<Attachment> filterSize(List<Attachment> list) {
//        List<Attachment> rsl = new ArrayList<>();
//        for (Attachment att : list) {
//            if (att.getSize() > 100) {
//                rsl.add(att);
//            }
//        }
//        return rsl;
//    }
//
//    public static List<Attachment> filterName(List<Attachment> list) {
//        List<Attachment> rsl = new ArrayList<>();
//        for (Attachment att : list) {
//            if (att.getName().contains("bug")) {
//                rsl.add(att);
//            }
//        }
//        return rsl;
//    }
    public static List<Attachment> filterSize(List<Attachment> list) {
       Predicate<Attachment> predicate = a -> a.getSize() > 100;
       return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = a -> a.getName().contains("bug");
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
