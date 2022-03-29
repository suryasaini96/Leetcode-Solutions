class Solution {
    
    /*
    // Approach 1
    public int maxScore(int[] cardPoints, int k) {
        // Approach: Minimizing the n-k elements in the middle will give max points from either end
        
        int maxSum = Integer.MIN_VALUE;
        
        // Finding the total sum first
        int totalSum = 0;
        for (int x: cardPoints) {
            totalSum+= x;
        }
        
        // Find window sum
        int windowSum = 0;
        for (int i = 0; i <= cardPoints.length - k - 1; i++) {
            windowSum+= cardPoints[i];
        }
        
        if ((totalSum - windowSum) > maxSum) 
            maxSum = totalSum - windowSum;
        
        // Now iterate till array end removing 1st element and adding last element to window
        int i=0; int j = cardPoints.length - k; 
        while (j < cardPoints.length) {
            windowSum-= cardPoints[i++];
            windowSum+= cardPoints[j++];
            if ((totalSum - windowSum) > maxSum) 
                maxSum = totalSum - windowSum;
        }
        return maxSum;
    } */
    
    
    // Approach 2: Cleaner
    public int maxScore(int[] cardPoints, int k) {
        int minContiguousSum = Integer.MAX_VALUE;
        int sum = 0;
        int totalSum = 0;
        int count = 0;
        int n = cardPoints.length;

        for (int i=0; i < n; i++){
            totalSum+= cardPoints[i];
            sum+= cardPoints[i];
            ++count;
            if (count == n - k){
                minContiguousSum = Math.min(minContiguousSum, sum);
                sum-= cardPoints[i-(n-k)+1];
                count--;
            }
        }
        // In case when all elements need to be picked
        if (n==k)
            return totalSum;
        return totalSum - minContiguousSum;
    }
}