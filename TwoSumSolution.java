package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TwoSumSolution {
    /*
    * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    * You may assume that each input would have exactly one solution, and you may not use the same element twice.
    * You can return the answer in any order.
    * */
    public static int[] twoSum(int[] nums, int target) {
        // List<Integer> numsList = Arrays.asList(nums);
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (Integer num: numsList) {
            int indexOne = numsList.indexOf(num);
            int newTarget = target - (int) num;
            numsList.set(indexOne, null);
            int indexTwo = numsList.indexOf(newTarget);
            if (indexTwo != -1) {
                System.out.println(indexOne + ":" + indexTwo);
                return new int[]{indexOne, indexTwo};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{3,2,4}, 6));
    }
}