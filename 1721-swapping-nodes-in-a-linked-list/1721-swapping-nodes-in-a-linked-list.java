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
    public ListNode swapNodes(ListNode head, int k) {
        int n = getListLength(head);
        List<ListNode> nodes = getNodes(head, k, n - k + 1);
        ListNode first = nodes.get(0);
        ListNode second = nodes.get(nodes.size() - 1);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
    
    public int getListLength(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }
        return n;
    }
    
    public List<ListNode> getNodes(ListNode head, int k1, int k2) {
        int n = 0;
        List<ListNode> res = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            n++;
            if (n == k1 || n == k2) {
                res.add(node);
            }
            node = node.next;
        }
        return res;
    }
}