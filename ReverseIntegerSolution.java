package com.leetcode;

public class ReverseIntegerSolution {
    /*
    * Given a 32-bit signed integer, reverse digits of an integer.
    * */
//     public int reverse(int x) {
//         String xAsString = ""+x;
//         int reversedX = 0;
//         int xLength = xAsString.length();
//         if (x<0){
//             xLength -= 1;
//         }
//         int xRemainder = x;
        
//         for (int i = 0; i<xLength; i++){
//             int ithPlace = xRemainder/(int) Math.pow(10, xLength-1-i)*(int) Math.pow(10,i);
//             xRemainder = xRemainder%(int) Math.pow(10, xLength-1-i);
//             reversedX += ithPlace;
//         }
        
//         return reversedX;
//     }
    
    public int reverse(int x) {
        String xAsString = ""+x;
        long reversedX = 0;
        int xLength = xAsString.length();
        if (x<0){
            xLength -= 1;
        }
        long xRemainder = (long) x;
        
        for (int i = 0; i<xLength; i++){
            long ithPlace = xRemainder/(long) Math.pow(10, xLength-1-i)*(long) Math.pow(10,i);
            xRemainder = xRemainder%(long) Math.pow(10, xLength-1-i);
            reversedX += ithPlace;
        }
        
        int reversedInt = 0;
        try{
            reversedInt = Math.toIntExact(reversedX); 
        }
        catch(ArithmeticException e){
            return 0;
        }
        return reversedInt;
    }
}
// BEST SOLUTION FOR TIME AND MEMEORY
// public int reverse(int x) {
//     int sign = x < 0 ? -1 : 1;
//     x = Math.abs(x);
    
//     long result = 0;
//     while (x > 0) {
//         result = (result * 10) + (x % 10);
//         x = x / 10;
//     }
    
//     result = result * sign;
    
//     if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
//         return 0;
//     }
    
//     return (int) result;
// }

