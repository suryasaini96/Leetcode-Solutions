class Solution {
    // Similar to allocate minimum number of pages
    public int shipWithinDays(int[] weights, int days) {
        // Finding minimum and maximum weights for each day
        int low = Integer.MAX_VALUE;
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            low = Math.min(weights[i], low);
            high += weights[i]; 
        }
        
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (isPossible(weights, mid, days)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    
    private boolean isPossible(int[] weights, int capacity, int days) {
        int day_count = 1;
        int weight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) return false; // If any weight exceeds capacity then not possible
            if (weight + weights[i] > capacity) { // If adding any weight[i] to current weight exceeds then reset weight and add days
                weight = weights[i];
                day_count++;
            } else { // Keep adding weights[i] to current weight
                weight += weights[i];
            }
        }
        if (day_count > days) // If day_count exceeds the days then it's not possible to ship with given capacity in given days
            return false;
        return true;
    }
}