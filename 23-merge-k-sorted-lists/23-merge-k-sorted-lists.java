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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode curr = head;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.node.val, b.node.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new Pair(lists[i], i));
            }
        }
        
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            curr.next = pair.node;
            curr = curr.next;
            lists[pair.idx] = pair.node.next;
            if (lists[pair.idx] != null)
                pq.add(new Pair(lists[pair.idx], pair.idx));
        }
        return head.next;
    }
}

class Pair {
    ListNode node;
    int idx;
    
    Pair(ListNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}