import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public String longestPalindrome(String s) {

        if (isPalindrome(s)){
            return s;
        }
        else{
            
            return "null";
        }

        
    }

    public static boolean isPalindrome(String s){
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        //Use Streams to convert String to a list of characters
        List<Character> charList = s.chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        char[] charArray = s.toCharArray();

        for (int i = 0; i<charList.size(); i++){
            Character ch = charList.get(i);
            if(i < charList.size()/2){
                if (charMap.containsKey(ch)){
                    charMap.put(ch, charMap.get(ch) +1);
                }
                else{
                    charMap.put(ch, 1);
                }
            }
            else if (i > charList.size()/2-1){
                if(charArray.length%2 == 1 && charList.indexOf(ch) == charArray.length/2 ){
                    continue;
                }
                if (charMap.containsKey(ch)){
                    charMap.put(ch, charMap.get(ch)-1);
                }
                else {
                    charMap.put(ch, -1);
                }
            }
        }

        for(Integer count: charMap.values()){
            if (count != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("cbbd")); 
        System.out.println(s.longestPalindrome("cbbc")); 
        System.out.println(s.longestPalindrome("cbabc"));  
        System.out.println(s.longestPalindrome("bybmimim"));   
    }
}