package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumBribesSolution {

    // Complete the minimumBribes function below.
    static void minimumBribesOne(int[] q) {
        if (q.length == 1){
            System.out.println(0);
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int minimumBribes = 0;
        int bribes = 0;
        int num;
        for(int i =0; i<q.length; i++){
            map.put(q[i], i+1);
        }
        for(int i=0; i<q.length; i++){
            num = q[i];
            if (map.get(num)<num){ 
                bribes = num-map.get(num);
                if (bribes > 2){
                    System.out.println("Too chaotic");
                    return;
                }
                else {
                    minimumBribes += bribes;
                }
            }
            else if (i<q.length-1 && q[i] > q[i+1]){
                minimumBribes += 1;
            }
            
        }
        System.out.println(minimumBribes);
    }

    static void minimumBribes(int[] q) {
        if (q.length == 1){
            System.out.println(0);
            return;
        }
        int minimumBribes = 0;
        int bribes = 0;
        int curr = 0;

        while(curr<q.length){
            bribes = 0;
            for (int i = curr; i<q.length; i++){
                if (q[i] < q[curr]){
                    bribes += 1;
                }
            }
            if (bribes > 2){
                System.out.println("Too chaotic");
                return;
            }
            else {
                minimumBribes += bribes;
            }
            curr++;
        }
        System.out.println(minimumBribes);
        
    }
    public static void main(String[] args) {
        minimumBribes(new int[]{1,2,5,3,7,8,6,4});
        minimumBribes(new int[]{2,5,1,3,4});
        minimumBribes(new int[]{2});
    }
}