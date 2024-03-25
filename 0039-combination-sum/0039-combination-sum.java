class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(candidates, 0, 0, target, res, new ArrayList<>());
        return res;
    }
    
    public void backtrack(int[] arr, int start, int sum, int target, List<List<Integer>> res, List<Integer> temp) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (sum + arr[i] > target) break;
            temp.add(arr[i]);
            backtrack(arr, i, sum + arr[i], target, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}