package com.leetcode;

public class WaterContainerSolution {
    /*
    * Given n non-negative integers a1, a2, ..., an ,
    * where each represents a point at coordinate (i, ai).
    * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    *
    * Find two lines, which together with x-axis forms a container,
    * such that the container contains the most water.
    * */
    public int maxArea(int[] height) {
        int h1 = 0, h2 = height.length - 1, area = 0;
        int maxArea = Math.abs(h2 - h1) * Math.min(height[h2], height[h1]);

        while (h1 < h2) {
            // Increment h1, check to see if new area is greater than current max area (width shrinks, but min height may increase)
            if (height[h1] < height[h2]) {
                h1++;
            } else {
                // Move in from h2 to see if the height(h2 -1) would give a larger area
                h2--;
            }
            // find area with a smaller width, but potenially large min height, update maxArea if necessary
            area = (h2 - h1) * Math.min(height[h2], height[h1]);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    // O(n^2) solution, inefficient
    public int maxAreaDraft(int[] height) {
        int h1 = 0, h2 = height.length-1;
        int maxArea = Math.abs(h2 - h1) * Math.min(height[h2], height[h1]);

        while (h1 < height.length-1) {
            int areaOne = 0, areaTwo = 0;
            for (int i = h2; i > h1; i--) {
                int area = Math.abs(i - h1) * Math.min(height[i], height[h1]);
                maxArea = Math.max(area, maxArea);
            }
            h1++;
        }
        return maxArea;
    }

    public int maxAreaDraftTwo(int[] height) {
        int maxAreaOne = 0, maxAreaTwo = 0;
        int h1 = 0, h2 = height.length-1;
        int maxArea = Math.abs(h2 - h1) * Math.min(height[h2], height[h1]);

        int areaRight = 0, areaLeft = 0, indexArea = 0;

        for (int i=0; i < height.length; i++) {
            areaLeft = height[i] * (i);
            areaRight = height[i] * (height.length-1-i);
            indexArea = Math.max(areaLeft, areaRight);
            if (indexArea > maxAreaOne){
                maxAreaOne = indexArea;
                h1 = i;
                System.out.println(i + " ll");
            } else if (indexArea >= maxAreaTwo && i>h2) {
                maxAreaTwo = indexArea;
                h2= i;
                System.out.println(i+" kk");
            }
        }
        return Math.abs(h2 - h1) * Math.min(height[h2], height[h1]);
    }

    public static void main(String[] args) {
        WaterContainerSolution solution = new WaterContainerSolution();
//        solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
//        solution.maxArea(new int[]{1,2,4,3});
    }

}
