class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        int currSum = 0;
        int minSize = Integer.MAX_VALUE;
        int p = 0;
        
        for (int i=0; i<nums.length; i++) {

            currSum+= nums[i];
                
            while(currSum>=s) {
                minSize = Math.min(minSize, i-p + 1);
                currSum -= nums[p];
                p++;  
            }
            

        }
        
        return (minSize==Integer.MAX_VALUE)? 0: minSize;

        
    }
}