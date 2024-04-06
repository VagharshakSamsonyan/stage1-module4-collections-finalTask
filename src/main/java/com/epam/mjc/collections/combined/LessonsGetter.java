package com.epam.mjc.collections.combined;

import java.util.*;

public class LessonsGetter {
    public Set<String> getLessons(Map<String, List<String>> timetable) {
        Set<String> allLessons = new HashSet<>();

        // Iterate through each day's list of lessons
        for (List<String> lessons : timetable.values()) {
            // Add each lesson to the set
            allLessons.addAll(lessons);
        }
        return allLessons;
    }

    public static void main(String[] args) {
        // Example timetable
        Map<String, List<String>> timetable = new HashMap<>();
        timetable.put("Monday", Arrays.asList("English"));
        timetable.put("Tuesday", Arrays.asList("Mathematics"));
        timetable.put("Wednesday", Arrays.asList("English", "Chemistry "));
        timetable.put("Thuirsday", Arrays.asList("Literature", "Mathematics"));
        timetable.put("Friday", Arrays.asList("Physics"));

        LessonsGetter getter = new LessonsGetter();
        Set<String> allLessons = getter.getLessons(timetable);

        // Print the set of all lessons
        System.out.println(allLessons);
    }
}
