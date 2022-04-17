class Solution {
    public int trap(int[] height) {
        int maxIndex = 0;
        int maxElement = height[0];
        for (int i=0; i<height.length; i++) {
            if (height[i] > maxElement) {
                maxIndex = i; 
                maxElement = height[i];
            }   
        }
        return captureLeft(height, maxIndex) + captureRight(height, maxIndex);
     }
    
    private int captureLeft(int[] height, int maxIndex) {
        int capturedWater = 0;
        for (int i=0; i<=maxIndex; i++) {
            int curr = height[i];
            int j=i+1;
            int currSum = 0;
            while (j <= maxIndex && height[j] < curr) {
                currSum+= curr - height[j]; // Capture current water
                j++;
            }
            if (j <= maxIndex && height[j] >= curr) {
                i = j - 1;
                capturedWater+= currSum;
            }
        }
        return capturedWater;
    }
    
    private int captureRight(int[] height, int maxIndex) {
        int capturedWater = 0;
         for (int i=height.length-1; i>=maxIndex; i--) {
             int curr = height[i];
             int j = i-1;
             int currSum = 0;
             while (j >= maxIndex && height[j] < curr) {
                 currSum+= curr - height[j];
                 j--;
             }
             if (j >= maxIndex && height[j] >= curr) {
                 i = j + 1;
                 capturedWater+= currSum;
             }
         }
        return capturedWater;
    }
}