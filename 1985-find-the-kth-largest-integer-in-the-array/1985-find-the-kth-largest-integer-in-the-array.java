import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(new BigInteger(nums[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.size() > 0 ? pq.peek().toString() : "-1"; 
    }
}