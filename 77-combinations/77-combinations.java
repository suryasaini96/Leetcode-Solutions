class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), 1, n, k);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> currList, int start, int n, int k) {
        if (currList.size() == k) {
            list.add(new ArrayList<>(currList));
            return;
        }
        for (int i = start; i <= n; i++) {
            currList.add(i);
            backtrack(list, currList, i+1, n, k);
            currList.remove(currList.size()-1);
        }
    }
}