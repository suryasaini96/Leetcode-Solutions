class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], max = prices[0];
        int profit = max - min;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) { // New minimum found. Now find maximum from this point onwards
                min = prices[i];
                max = prices[i];
            }
            if (prices[i] > max) 
                max = prices[i];
            profit = Math.max(profit, max - min);
        }
        return profit;
    }
}