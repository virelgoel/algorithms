/*
 * Copyright 2019, FMR LLC.
 * All Rights Reserved
 * Fidelity Confidential Information
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

/*
 Find all positive integer solutions under n to a^3 + b^3= c^3 + d^3
 */
public class SumOfCubes {
    static void findPairs(int n) {
        double cubeRoot = Math.cbrt(n);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int x = 1; x < cubeRoot; x++) {
            for (int y = x + 1; y <= cubeRoot; y++) {
                int sum = x*x*x + y*y*y;

                if (sum != n)
                    continue;

                if (map.containsKey(sum)) {
                    System.out.println(n + " -> [" + x + ", " +  y + "]" + " , " + map.get(sum).toString());
                }
                else {
                   List<Integer> a = new ArrayList<>();
                   a.addAll(Arrays.asList(x, y));
                    map.put(sum, a);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 15000; i++)
            SumOfCubes.findPairs(i);
    }
}
