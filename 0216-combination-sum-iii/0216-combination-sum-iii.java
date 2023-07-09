class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(k, 0, n, 1, ans, res);
        return res;
    }
    
    public void dfs(int k, int sumSoFar, int sum, int start, 
                                   List<Integer> ans, List<List<Integer>> result) {
        if (k == 0 && sumSoFar == sum) {
            result.add(new ArrayList<>(ans));
            return;
        }
        
        if (start > 9 || sumSoFar > sum) return;
        
        for (int i = start; i <= 9; i++) {
            sumSoFar += i;
            ans.add(i);
            dfs(k-1, sumSoFar, sum, i + 1, ans, result);
            ans.remove(ans.size()-1);
            sumSoFar -= i;
        }
        
    }
}