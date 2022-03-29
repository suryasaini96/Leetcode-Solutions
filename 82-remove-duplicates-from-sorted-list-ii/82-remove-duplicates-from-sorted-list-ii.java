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
        // When list is empty or has only 1 element
        if (head==null || head.next == null) return head;

        // Calling prev as itr here
        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;
        itr.next = head;
        ListNode curr = head.next;

        while (curr!=null) {
            // Loop to take curr to potential non-duplicate
            boolean loopHasRun = false;
            while(curr!=null && itr.next.val == curr.val){
                loopHasRun = true;
                curr = curr.next;
            }

            if(loopHasRun) // There were duplicates
                itr.next = curr; // Skip the duplicates to potential non-dup
            else // It is a unique value
                itr = itr.next; // Include the unique value

            if (curr!=null) // curr could be null after last value
                curr = curr.next;
        }

		return dummy.next;
    }
}