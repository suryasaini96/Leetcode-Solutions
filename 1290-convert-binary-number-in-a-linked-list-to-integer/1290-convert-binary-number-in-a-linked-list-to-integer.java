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
class Solution {
    public int getDecimalValue(ListNode head) {
        int length = getLength(head);
        int result = 0;
        while (head != null) {
            result += head.val * Math.pow(2, length - 1);
            head = head.next;
            length--;
        }
        return result;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while (head!=null) {
            head = head.next;
            length++;
        }
        return length;
    }
}