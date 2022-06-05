class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, list, result, 0);
        return result;
    }
    
    public void dfs(int[][] graph, List<Integer> list, List<List<Integer>> result, int i) {
        if (i == graph.length-1) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int j = 0; j < graph[i].length; j++) {
            list.add(graph[i][j]);
            dfs(graph, list, result, graph[i][j]);
            list.remove(list.size()-1);
        }
    }
}