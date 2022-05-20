class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, 0, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> currList, int nums[], int start, int target, int sum) {
        if (sum == target) {
            list.add(new ArrayList<>(currList));
            return;
        } else if (sum > target || start >= nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) // skip the duplicates
                continue;
            // if (sum + nums[i] > target)
            //     break;
            currList.add(nums[i]);
            backtrack(list, currList, nums, i+1, target, sum = sum + nums[i]);
            currList.remove(currList.size()-1);
            sum = sum - nums[i];
        }
    }
}