package com.leetcode;

public class PalidromeNumber {
    /*
    * Determine whether an integer is a palindrome.
    * An integer is a palindrome when it reads the same backward as forward.
    * */
    public static boolean isPalindromeOne(int x){
        String num = ""+x;
        StringBuilder sb = new StringBuilder(num);
        String reverseNum = sb.reverse().toString();
        return num.equals(reverseNum);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x){
        long result = 0;
        int num = x;
        if (x < 0) {
            return false;
        } else {
            while (x>0){
                result = result*10 + x%10;
                x = x/10;
            }
        }
        return result == (long) num;
    }
}
