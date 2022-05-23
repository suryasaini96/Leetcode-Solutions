class Solution {
    public int[] productExceptSelf(int[] nums) {
        int products[] = new int[nums.length];
        
        // Input: [1,2,3,4]
        // Find the suffix products and store it in resultant array only
        // Suffix product: [24, 24, 12, 4]
        int prod = 1;
        for (int i = nums.length-1; i >=0; i--){
            products[i] = nums[i] * prod;
            prod = products[i];
        }

        prod = 1; // Reset the prod variable
        // Again calculate product so far from start till current value
        // Now: multiply product so far (for previous value) with products[i+1]
        // Take care of out of bounds condition
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 >= nums.length)
                products[i] = prod * 1;
            else
                products[i] = prod * products[i+1];
            prod = prod * nums[i];
        }
        
        return products;
    }
}