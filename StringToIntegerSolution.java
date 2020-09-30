package com.leetcode;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToIntegerSolution {
    /*
    Implement atoi which converts a string to an integer.
    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
    If no valid conversion could be performed, a zero value is returned.

    Note:
    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
    */

    public static int myAtoi(String str) {
        // Store number in a big integer to handle string to number conversion
        BigInteger result;
        // Define groups in regex so that group(2) will be integer needed
        String stringPattern = "( *)?([+\\-]?\\d+)(\\.\\d+)?(\\D*.*)?";
        Pattern numPattern = Pattern.compile(stringPattern);
        Matcher matcher = numPattern.matcher(str);

        if (!matcher.matches()){
            return 0;
        }

        result = new BigInteger(matcher.group(2));
        // Set result to a maximum Integer.MAX_VALUE and minimum of Integer.MIN_VALUE
        result = result.min(BigInteger.valueOf((long) Integer.MAX_VALUE));
        result = result.max(BigInteger.valueOf((long) Integer.MIN_VALUE));

        System.out.println(result.intValue());
        return result.intValue();
    }

    // Convert string to long using Long.parseLong
    public static int myAtoiOne(String str) {
        long result = 0;
        String stringPattern = "( *)?([+\\-]?\\d+)(\\.\\d+)?(\\D*.*)?";
        Pattern numPattern = Pattern.compile(stringPattern);
        Matcher matcher = numPattern.matcher(str);

        if (!matcher.matches()){
            return 0;
        }

        result = Long.parseLong(matcher.group(2));

        if (result > Integer.MAX_VALUE){
            return (int) Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE){
            return (int) Integer.MIN_VALUE;
        }

        System.out.println(result);
        return (int) result;
    }

    public static void main(String[] args) {
        myAtoi("33.514159");
        myAtoi("+42");
        myAtoi("  -0012a42");
        myAtoi("   -42word ");
        myAtoi("4193 with words");
        myAtoi("words and 987");
        myAtoi("20000000000000000000");
    }
}
