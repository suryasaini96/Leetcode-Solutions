class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Maintains the largest element to the right
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Maintains the smallest element to the left 
        
        int start = 0;
        double result[] = new double[nums.length - k + 1];
        for (int end = 0; end < nums.length; end++) {
            add(nums[end], minHeap, maxHeap);
            int size = end - start + 1;
            if (size == k) {
                result[start] = findMedian(minHeap, maxHeap);
                remove(nums[start], minHeap, maxHeap);
                start++;
            }
        }
        return result;   
    }
    
    
    private void add(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance(minHeap, maxHeap); // Balance the heaps
    }
    
    private void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }
    
    private void remove(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (num <= maxHeap.peek())
            maxHeap.remove(num);
        else //if (num > minHeap.peek())
            minHeap.remove(num);
        balance(minHeap, maxHeap);
    }
    
    private double findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
    }
    
}