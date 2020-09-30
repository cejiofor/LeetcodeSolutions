package com.leetcode;

import java.util.*;

public class LetterCombinations {
    /*
    * Given a string containing digits from 2-9 inclusive,
    * return all possible letter combinations that the number could represent.
    * A  mapping of digit to letters (just like on the telephone buttons) is given below.
    * Note that 1 does not map to any letters.
    * */
    public List<String> letterCombinations(String digits) {
        // Create a map of numbers as a key and possible letters as values
        Map<Integer, String[]> digitMap = new HashMap<>();
        digitMap.put(2, new String[]{"a","b","c"});
        digitMap.put(3, new String[]{"d","e","f"});
        digitMap.put(4, new String[]{"g","h","i"});
        digitMap.put(5, new String[]{"j","k","l"});
        digitMap.put(6, new String[]{"m","n","o"});
        digitMap.put(7, new String[]{"p","q","r","s"});
        digitMap.put(8, new String[]{"t","u","v"});
        digitMap.put(9, new String[]{"w","x","y","z"});

        List<String> combos = new ArrayList<String>();
        int currIndex = digits.length() - 1;
        // Loop through input string starting at the end, starting a
        while (currIndex >= 0) {
            Integer num = Integer.parseInt("" + digits.charAt(currIndex));
            if (combos.isEmpty()) {
                for (String s : digitMap.get(num)) {
                    combos.add(s);
                }
            } else {
                // Copy the current subset of combinations, then clear the combos array for new longer combos
                List<String> comboCopy = new ArrayList<>(combos);
                combos.clear();
                for (String s : digitMap.get(num)) {
                    for (String combo : comboCopy) {
                        combos.add(s+combo);
                    }
                }
            }
            currIndex -= 1;
        }

//        List<String> comboCopy = combos.stream().filter(ele -> ele.length()==digits.length()).collect(Collectors.toList())
        return combos;
    }

    public static void main(String[] args) {
        List<String> ans = new LetterCombinations().letterCombinations("23");
        System.out.println(Arrays.toString(ans.toArray()));
        ans = new LetterCombinations().letterCombinations("");
        System.out.println(Arrays.toString(ans.toArray()));
    }


}
