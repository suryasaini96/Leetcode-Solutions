class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxArea = 0;
        
        
        while(i<j){
            
            if(height[i]<height[j]){
                maxArea = Math.max(maxArea, height[i]*(j-i));
                i++;
            }
            else if (height[i]>=height[j]){
                maxArea = Math.max(maxArea, height[j]*(j-i));
                j--;             
            }

        }
        
        return maxArea;
        
        
        
        
    }
}