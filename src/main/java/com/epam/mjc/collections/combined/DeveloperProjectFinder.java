package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> developerProjects = new ArrayList<>();

        // Iterate through the projects
        for (Map.Entry<String, Set<String>> entry : projects.entrySet()) {
            String project = entry.getKey();
            Set<String> developers = entry.getValue();

            // Check if the requested developer is associated with the project
            if (developers.contains(developer)) {
                developerProjects.add(project);
            }
        }

        // Sort the developer projects according to the specified criteria
        Collections.sort(developerProjects, (p1, p2) -> {
            // Compare project names by length in descending order
            int lengthComparison = Integer.compare(p2.length(), p1.length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            // If lengths are equal, compare alphabetically in reverse order
            return p2.compareTo(p1);
        });

        return developerProjects;
    }

    public static void main(String[] args) {
        // Example projects map
        Map<String, Set<String>> projects = new HashMap<>();
        projects.put("CSO", new HashSet<>(Arrays.asList("Ivan", "Anna", "Lidia", "Antony")));
        projects.put("VVaS", new HashSet<>(Arrays.asList("Mary", "Ben", "Max")));
        projects.put("LJA", new HashSet<>(Arrays.asList("Oleg", "Ivan", "Alex")));

        String developer = "Ivan";

        DeveloperProjectFinder finder = new DeveloperProjectFinder();
        List<String> developerProjects = finder.findDeveloperProject(projects, developer);

        // Print the list of projects for the requested developer
        System.out.println(developerProjects);
    }
}
