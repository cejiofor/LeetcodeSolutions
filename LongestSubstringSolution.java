package com.leetcode;

import java.util.HashSet;

class LongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int maxLength = 0;
        int startIndex = 0;
        HashSet<Character> charSet = new HashSet<Character>();
        char[] charArray = s.toCharArray();
        while (startIndex < s.length()-length){
           if (charSet.contains(charArray[startIndex+length])){
                charSet.clear();
                startIndex +=1;
                length = 0;
            }
            else{
                charSet.add(charArray[startIndex+length]);
                length += 1;
                if (length > maxLength){
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubstringSolution test = new LongestSubstringSolution();
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
    }
    // public int lengthOfLongestSubstring(String s) {
    //     int length = 0;
    //     int maxLength = 0;
    //     int startIndex = 0;
    //     HashSet<Character> charSet = new HashSet<Character>();
    //     char[] charArray = s.toCharArray();
    //     while (startIndex < s.length()){
    //         for (int i = startIndex; i< charArray.length; i++){
    //             if (charSet.contains(charArray[i])){
    //                 charSet.clear();
    //                 startIndex +=1;
    //                 length = 0;
    //                 break;
    //             }
    //             else{
    //                 charSet.add(charArray[i]);
    //                 length += 1;
    //                 if (length > maxLength){
    //                     maxLength = length;
    //                 }
    //             }
    //         }
    //     }
    //     return maxLength;
    // }
}