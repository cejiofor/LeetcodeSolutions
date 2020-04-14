package com.leetcode;

class Solution {
    // Solution using Dynamic Programming
    public String longestPalindrome(String s) {
        if (s == null || s.length()<1){
            return s;
        }

        String longestSubStr = "";
        int length = s.length();
        int maxLength = 0;

        // Table keeping track of longest substring
        // i = start index of string, j = ending index
        boolean[][] table = new boolean[length][length];

        // Loop over lenghts of substring, from 0 to length of the string
        for (int len =0; len<length; len++) {
            // Loop over starting index i
            for (int i = 0; i <length-len; i++) {
                int j = i+len;
                // check first adn last char are the same and that char at i &j are being added to an exisiting palindrome
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || table[i+ 1][j - 1])) {
                    table[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        longestSubStr = s.substring(i, i + maxLength);
                    }
                }
            }
        }
        return longestSubStr;
    }



    // Time Out while running
    public String longestPalindromeOne(String s) {
        String longestSubStr = "";
        if (isPalindrome(s)){
            return s;
        }
        else{
            for (int i=s.length()-1; i>0; i--){
                for (int j = 0; j<=s.length()-i; j++) {
                    String sub = s.substring(j, j+i);
                    if (isPalindrome(sub)){
                        longestSubStr = sub;
                        return longestSubStr;
                    }
                }
            }
        }
        return longestSubStr;
    }

    public static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        String reverseString = sb.reverse().toString();
        return s.toLowerCase().equals(reverseString);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("aacbbcad"));
        System.out.println(s.longestPalindrome("cbbggs"));
        System.out.println(s.longestPalindrome("cbabc"));
        System.out.println(s.longestPalindrome("bybmimim"));
        System.out.println(s.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}