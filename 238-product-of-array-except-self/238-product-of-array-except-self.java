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
        // Now: multiply previous product so far with products[i+1] (which has suffix products)
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 >= nums.length) // Take care of out of bounds condition
                products[i] = prod * 1; // For out of bounds multiple previous product so far with 1
            else
                products[i] = prod * products[i+1]; // Multiply prev product so far with next value from suffix products 
            prod = prod * nums[i]; // Calculate previous product so far
        }
        
        // For eg: at 1st index:
        // previous product so far = 1
        // and suffix product[i+1] = 12
        // so product[i] = 1*12
        return products;
    }
}