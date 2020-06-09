package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WaterContainerSolution {
    public int maxArea(int[] height) {
        int maxAreaOne = 0, maxAreaTwo = 0;
        int h1 = 0, h2 = 0;
        Map<Integer, Integer> coord = new HashMap<>();
        int areaRight = 0, areaLeft = 0, indexArea = 0;

        for (int i=0; i < height.length; i++) {
            areaLeft = height[i] * (i+1 - 0);
            areaRight = height[i] * ((height.length+1)-i);
            indexArea = Math.max(areaLeft, areaRight);
            if (indexArea > maxAreaOne){
                maxAreaOne = indexArea;
                h1 = i;
            } else if (indexArea > maxAreaTwo) {
                maxAreaTwo = indexArea;
                h2= i;
            }
        }
        return Math.abs(h2 - h1) * Math.min(height[h2], height[h1]);
    }

    public static void main(String[] args) {
        WaterContainerSolution solution = new WaterContainerSolution();
        solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

}
