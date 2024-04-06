package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> resultMap = new HashMap<>();

        // Iterate through the keys of the source map
        for (String key : sourceMap.keySet()) {
            int keyLength = key.length();

            // Get or create the set for the current length
            Set<String> keySet = resultMap.computeIfAbsent(keyLength, k -> new HashSet<>());

            // Add the key to the set
            keySet.add(key);
        }
        return resultMap;
    }

    public static void main(String[] args) {
        // Example source map
        Map<String, Integer> sourceMap = new HashMap<>();
        sourceMap.put("one", 1);
        sourceMap.put("two", 2);
        sourceMap.put("three", 3);
        sourceMap.put("five", 5);
        sourceMap.put("ten", 10);

        MapFromKeysCreator creator = new MapFromKeysCreator();
        Map<Integer, Set<String>> resultMap = creator.createMap(sourceMap);

        // Print the resulting map
        for (Map.Entry<Integer, Set<String>> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
