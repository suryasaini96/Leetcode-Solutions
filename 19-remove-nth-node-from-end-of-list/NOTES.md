// Using 2 pointer approach: O(n)
second = head
first = head
1. Set second pointer k places from first
2. Now move second and first pointer 1 step each time till second pointer is the last element
3. Now first pointer will be 1 step before the element to be removed.
4. Remove it by first.next = first.next.next
5. Return head