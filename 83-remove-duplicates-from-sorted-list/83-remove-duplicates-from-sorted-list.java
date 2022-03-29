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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
         if (!set.contains(curr.val)){
            set.add(curr.val);
            prev = curr;
         } 
         else 
            prev.next = curr.next;
         curr = curr.next;
        }
        return head;
    }
}