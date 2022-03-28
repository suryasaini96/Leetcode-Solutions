class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
  
        Set<List<Integer>> list = new HashSet<>();
        
        //using 3 pointer technique
        Arrays.sort(nums);
        int i,j,k;
                
        for (i=0; i<nums.length-2; i++){
        	j = i+1;
            k = nums.length-1;
            while(j<k){
                if (nums[j] + nums[k] == -nums[i]) // found the triplet, change i,j and k also
                	list.add(Arrays.asList(nums[i], nums[j++], nums[k--]));              
                else if (-nums[i] < nums[j] + nums[k])  // we are more postive side .. dec k
                    k--;
                else if (-nums[i] > nums[j] + nums[k]) // we move j to more postive side .. inc j
                    j++;
            }
        }
        
        return new ArrayList<>(list);
        
    }
}