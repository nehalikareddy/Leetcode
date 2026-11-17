/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        String ans1 = "";
        while (temp1 != null) {
            ans1 = ans1 + temp1.val;
            temp1 = temp1.next;
        }
        String rev1 = new StringBuilder(ans1).reverse().toString();

        String ans2 = "";
        while (temp2 != null) {
            ans2 = ans2 + temp2.val;
            temp2 = temp2.next;
        }
        String rev2 = new StringBuilder(ans2).reverse().toString();

        String ans3 = new BigInteger(rev1).add(new BigInteger(rev2)).toString();

        ListNode temp = dummy;
        for (int i = ans3.length() - 1; i >= 0; i--) {
            int digit = ans3.charAt(i) - '0';
            temp.next = new ListNode(digit);
            temp = temp.next;
        }

        return dummy.next;
    }
}