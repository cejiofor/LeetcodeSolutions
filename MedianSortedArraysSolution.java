package com.leetcode;

public class MedianSortedArraysSolution {
    /*
    * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    * Follow up: The overall run time complexity should be O(log (m+n)).
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        int i = 0, j = 0, k = 0;

        int[] join = new int[nums1.length+nums2.length];

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                join[k] = nums1[i];
                i++;
            } else{
                join[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<nums1.length){
            join[k] = nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            join[k] = nums2[j];
            j++;
            k++;
        }
        if (join.length%2 == 0){
            median = ((double) join[join.length/2] + (double) join[join.length/2-1])/2;
        } else{
            median = ((double) join[join.length/2]);
        }

        System.out.println(median);
        return median;

    }

    public static void main(String[] args) {
        MedianSortedArraysSolution app = new MedianSortedArraysSolution();
        app.findMedianSortedArrays(new int[]{1,2},new int[] {3,4});
        app.findMedianSortedArrays(new int[]{1,3},new int[] {2});
    }
}
