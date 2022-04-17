class Solution {
    public int trap(int[] height) {
        int maxIndex = 0;
        int maxElement = height[0];
        // Find the peak value and it's index
        for (int i=0; i<height.length; i++) {
            if (height[i] > maxElement) {
                maxIndex = i; 
                maxElement = height[i];
            }   
        }
        return captureLeft(height, maxIndex) + captureRight(height, maxIndex); // Capture left and capture right
     }
    
    private int captureLeft(int[] height, int maxIndex) { // Capture water from 0th index till peak value index
        int capturedWater = 0;
        for (int i=0; i<=maxIndex; i++) {
            int curr = height[i];
            int j=i+1;
            int currSum = 0;
            while (j <= maxIndex && height[j] < curr) {
                currSum+= curr - height[j]; // Capture current water 
                j++;
            }
            if (j <= maxIndex && height[j] >= curr) { // When height is larger or equal than curr: set i = j and add captured water
                i = j - 1;
                capturedWater+= currSum;
            }
        }
        return capturedWater;
    }
    
    private int captureRight(int[] height, int maxIndex) { // Capture water from nth index till peak value index
        int capturedWater = 0;
         for (int i=height.length-1; i>=maxIndex; i--) {
             int curr = height[i];
             int j = i-1;
             int currSum = 0;
             while (j >= maxIndex && height[j] < curr) {
                 currSum+= curr - height[j]; // Capture current water
                 j--;
             }
             if (j >= maxIndex && height[j] >= curr) { // When height is larger than or equal to curr: set i = j and add captured water
                 i = j + 1;
                 capturedWater+= currSum;
             }
         }
        return capturedWater;
    }
}