class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> currList, int [] nums, int start) {
        list.add(new ArrayList<>(currList));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            currList.add(nums[i]);
            backtrack(list, currList, nums, i + 1);
            currList.remove(currList.size() - 1);
        }
    } 
}