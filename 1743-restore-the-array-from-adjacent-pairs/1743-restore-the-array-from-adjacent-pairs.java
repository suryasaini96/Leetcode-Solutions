class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] ans = new int[adjacentPairs.length+1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] edge: adjacentPairs) {
            List<Integer> list1 = graph.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge[1]);
            graph.put(edge[0], list1);
            List<Integer> list2 = graph.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            graph.put(edge[1], list2);
        }
        
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                stack.push(entry.getKey());
                break;
            }    
        }
        
        int k = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            ans[k++] = curr;
            set.add(curr);
            for (int ele : graph.get(curr)) {
                if (!set.contains(ele)) {
                    stack.push(ele);
                }
            }
        }
        return ans;
    }
}