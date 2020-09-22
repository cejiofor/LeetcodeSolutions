package com.leetcode;

import java.util.*;

public class ThreeSumSolution {
    /*
        Given an array nums of n integers, are there elements a, b, c in nums
        such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // Create a set to hold unique triplicates
        Set<List<Integer>> slnSet = new HashSet<>();

        // Edge cases
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[j]);
                    newList.add(nums[k]);
                    slnSet.add(newList);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }
        }

        return new ArrayList<List<Integer>>(slnSet);

        /*
            List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j< nums.length-1; j++) {
                int remain = 0 - (numList.get(i) + numList.get(j));
                if (numList.subList(j + 1, numList.size()).contains(remain)) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(numList.get(i));
                    newList.add(numList.get(j));
                    newList.add(remain);
                    slnSet.add(newList);
                }
            }
        */
    }

    public static void main(String[] args) {
        new ThreeSumSolution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
