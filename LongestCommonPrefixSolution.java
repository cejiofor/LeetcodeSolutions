package com.leetcode;

public class LongestCommonPrefixSolution {

    public static String longestCommonPrefix(String[] strs){
        int arrLength = strs.length;
        if(arrLength == 0){
            return "";
        }
        else if (arrLength == 1){
            return strs[0];
        }
        
        int currentPosition = 0;
        // char currentChar;
        while(currentPosition < Integer.MAX_VALUE){
            for (int i=0; i<arrLength; i++){
                // If current string in array is shorter than the 0-index curernt position, return string as no prfix will match further
                if (strs[i].length() == currentPosition){
                    return strs[i].substring(0, currentPosition);
                }
                //Breaking condiiton - if all character match before, and current character does not match, return previous match
                if(strs[0].charAt(currentPosition) != strs[i].charAt(currentPosition)){
                    return strs[0].substring(0, currentPosition);
                }
            }
            currentPosition++;
        }
        return "";
    }


    // public static String longestCommonPrefixOne(String[] strs) {
    //     String longestCommon = "";
    //     int matchIndex = -1;
    //     boolean matchChar = false;
    //     if (strs.length == 0){
    //         return longestCommon;
    //     }
    //     else if (strs.length == 1){
    //         return strs[0];
    //     } 
    //     do{
    //         matchIndex += 1;
    //         matchChar = indexCheck(matchIndex, strs);
    //         if (matchChar){  
    //             longestCommon = strs[0].substring(0, matchIndex+1);
    //         }
    //     }while (matchChar && matchIndex+1<strs[0].length());

    //     return longestCommon;
    // }

    // public static boolean indexCheck(int index, String[] strs){
    //     char ch = strs[0].charAt(index);
    //     boolean matchChar = true;
    //     for (String s: strs){
    //         if(s.length() == 0){
    //             matchChar = false;
    //         }
    //         else if (s.charAt(index) != ch){
    //             matchChar = false;
    //         }
    //     }
    //     return matchChar;
    // }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"",""}));
        System.out.println(longestCommonPrefix(new String[]{"a", "apple", "a"}));
    }
}
