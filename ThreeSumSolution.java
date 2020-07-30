package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumSolution {
    /*
        Given an array nums of n integers, are there elements a, b, c in nums
        such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> slnSet = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<>();

        // Add each number and a counter for each number
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            int a=Integer.MIN_VALUE, b=Integer.MIN_VALUE, c=Integer.MIN_VALUE;
            if (map.keySet().contains(key*-1)) {
                if (map.keySet().contains(0)) {
                    a = key;
                    b = key*-1;
                    c = 0;

                    map.put(a, map.get(a) - 1);
                    map.put(b, map.get(b) - 1);
                    map.put(c, map.get(c) - 1);
                    int[] sln = new int[]{a, b, c};
                    System.out.println(Arrays.toString(sln));
                    slnSet.add(Arrays.stream(sln).boxed().collect(Collectors.toList()));
                }
                else{}
            }

            //Remove if count is zero
            if (map.get(a) == 0) {
                map.remove(a);
            }
            if (map.get(b) == 0) {
                map.remove(b);
            }if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return null;

    }

//    public int[] remover(int num, Map map) {
//        if (map.keySet().contains(num*-1)) {
//            if (map.keySet().contains(0)) {
//                a = num;
//                b = num*-1;
//                c = 0;
//
//                map.put(a, map.get(a) - 1);
//                map.put(b, map.get(b) - 1);
//                map.put(c, map.get(c) - 1);
//                int[] sln = new int[]{a, b, c};
//                System.out.println(Arrays.toString(sln));
//                slnSet.add(Arrays.stream(sln).boxed().collect(Collectors.toList()));
//            }
//    }

    public static void main(String[] args) {
        new ThreeSumSolution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
