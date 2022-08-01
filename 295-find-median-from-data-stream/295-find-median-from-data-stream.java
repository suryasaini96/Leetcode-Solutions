class MedianFinder {
    
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
    }
    
    private void balance() {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());   
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */