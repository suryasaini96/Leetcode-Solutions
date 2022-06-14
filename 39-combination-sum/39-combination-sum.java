class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(candidates, list, new ArrayList<>(), 0, 0, target);
        return list;
    }
    
    private void backtrack(int nums[], List<List<Integer>> list, List<Integer> currList, int start, int sum, int target) {
        if (sum == target) {
            list.add(new ArrayList<>(currList));
            return;
        }
        if (sum > target || start >= nums.length) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target)
                break;
            currList.add(nums[i]);
            backtrack(nums, list, currList, i, sum = sum + nums[i], target);
            currList.remove(currList.size()-1);
            sum = sum - nums[i];
        }
    }
}