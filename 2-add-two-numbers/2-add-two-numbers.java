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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = null, head = null;
        int carry = 0;

        while(l1!= null || l2 != null) {  
            
            int sum = 0;
            
            if (l1!= null){
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum+= carry;
            
            int value = sum%10;
            carry = sum/10;
            
            ListNode node = new ListNode(value);
            
            if(result!=null){
                result.next = node;
                result = result.next;
            } else {
                result = head = node;
            }
            
            if (carry>0){
                result.next = new ListNode(carry);
            }
              
        }
        
        return head;

    }
}