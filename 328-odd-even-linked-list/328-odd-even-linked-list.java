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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOddNode = new ListNode(0);
        ListNode dummyEvenNode = new ListNode(0);
        
        ListNode oddNode = dummyOddNode;
        ListNode evenNode = dummyEvenNode;
        
        ListNode node = head;
        int cnt = 1;
        while (node != null) {
            if (cnt % 2 == 1) {
                oddNode.next = node;
                oddNode = oddNode.next;
            }
            else {
                evenNode.next = node;
                evenNode = evenNode.next;
            }
            node = node.next;
            cnt++;
        }
        
        evenNode.next = null;
        oddNode.next = dummyEvenNode.next;
        
        return dummyOddNode.next;
    }
}