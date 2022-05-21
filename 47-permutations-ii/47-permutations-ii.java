class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> currList, int[] nums, boolean[] used) {
        if (currList.size() == nums.length) {
            list.add(new ArrayList<>(currList));
            return;
        } else {
            for (int i=0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;        
                currList.add(nums[i]);
                backtrack(list, currList, nums, used);
                currList.remove(currList.size()-1);
                used[i] = false;
            }
        }
    }
}