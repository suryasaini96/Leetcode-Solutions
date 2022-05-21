class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> currList, int nums[]) {
        if (currList.size() == nums.length) {
            list.add(new ArrayList<>(currList));
            return;
        } else {
            for (int i=0; i<nums.length; i++) {
                if (currList.contains(nums[i])) continue;
                currList.add(nums[i]);
                backtrack(list, currList, nums);
                currList.remove(currList.size()-1);
            }
        }
    }
}