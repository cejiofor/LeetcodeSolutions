package com.leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p){
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        sb.append(p);
        sb.append("$");

        String pattern = sb.toString();
        System.out.println(s.matches(pattern));
        return s.matches(pattern);
    }

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        matching.isMatch("bb", "a");
        matching.isMatch("aa", "a*");
        matching.isMatch("ab", ".*");
        matching.isMatch("aab", "c*a*b");
        matching.isMatch("mississippi", "mis*is*p*.");

    }
}
