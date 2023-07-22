class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        return dfs(arr, vis, start);
    }
    
    public boolean dfs(int[] arr, boolean[] vis, int i) {
        if (i < 0 || i >= arr.length || vis[i])
            return false;
        if (arr[i] == 0)
            return true;
        
        vis[i] = true;
        int curr = arr[i];
        return dfs(arr, vis, i + curr) || dfs(arr, vis, i - curr);
    }
}