import java.math.BigInteger;

/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *  int val; 
 *  ListNode next; 
 *  ListNode(int x) { val = x; } }
 */

class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger numOne = new BigInteger("0");
        BigInteger numTwo = new BigInteger("0");
        BigInteger decimalPlace = new BigInteger("1");
        while (l1 != null){
            numOne = numOne.add(decimalPlace.multiply(BigInteger.valueOf(l1.val)));
            l1 = l1.next;
            decimalPlace = decimalPlace.multiply(new BigInteger("10"));
        }
        
        decimalPlace = new BigInteger("1");
        while (l2 != null){
            numTwo = numTwo.add(decimalPlace.multiply(BigInteger.valueOf(l2.val)));
            l2 = l2.next;
            decimalPlace = decimalPlace.multiply(new BigInteger("10"));
        }
        
        BigInteger sum = numOne.add(numTwo);
        String sumString = sum.toString();
        System.out.println(sumString);
        
        ListNode sumListNode = new ListNode(Integer.parseInt("" + sumString.charAt(sumString.length()-1)));
        ListNode current = sumListNode;
        for (int i=sumString.length()-2; i>=0; i--){
            ListNode nextNode = new ListNode(0);
            current.next = nextNode;
            nextNode.val += Integer.parseInt("" + sumString.charAt(i));
            current = nextNode;
        }
         
        return sumListNode;
    }
}