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
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack= new Stack<>();
        Stack<ListNode> result = new Stack<>();
        
        while (l1 != null) {
            firstStack.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            secondStack.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        while (!firstStack.isEmpty() || !secondStack.isEmpty()) {
            int res = 0;
            if (!firstStack.isEmpty() && !secondStack.isEmpty()) {
                res = firstStack.pop() + secondStack.pop() + carry;
                carry = getCarry(res);
                ListNode node = new ListNode(res%10);
                result.push(node);
            } else if (!firstStack.isEmpty()) {
                res = firstStack.pop() + carry;
                carry = getCarry(res);
                ListNode node = new ListNode(res%10);
                result.push(node);
            } else if (!secondStack.isEmpty()) {
                res = secondStack.pop() + carry;
                carry = getCarry(res);
                ListNode node = new ListNode(res%10);
                result.push(node);
            }
        }
        
        if (carry > 0) {
            result.push(new ListNode(carry));
        }
        
        ListNode head = !result.isEmpty() ? result.pop() : null;
        ListNode curr = head;
        while (!result.isEmpty()) {
            curr.next = result.pop();
            curr = curr.next;
        }
        
        if (curr != null)
            curr.next = null;
        
        return head;
    }
    
    private int getCarry(int num) {
        if (num >= 10)
            return 1;
        return 0;
    }
}