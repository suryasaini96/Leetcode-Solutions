class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair<Integer, Double>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Initialise the adjacency list
        }
        
        // Make the adjecency list for nodes
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            double p = succProb[i];
            adjList.get(a).add(new Pair<>(b, p));
            adjList.get(b).add(new Pair<>(a, p));
        }
        
        double[] ans = new double[n + 1];
        ans[start] = 1.0; // Probability of start node is 1.0
        
        // Start BFS traversal from start node
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int s = q.poll();
            for (Pair<Integer, Double> pair : adjList.get(s)) {
                int e = pair.getKey();
                double p = pair.getValue();
                double currProb = ans[e];
                double newProb = p * ans[s];
                if (newProb > currProb) { // If prob of edge * prev probability is more than currProb of e node
                    ans[e] = newProb;
                    q.add(e); // Also add the e node to our BFS queue for further traversal
                }
            }
        }
        
        return ans[end];   
    }
}

public class Pair<K,V> {
    private K key;
    private V value;

    Pair(K _key, V _value) {
        this.key = _key;
        this.value = _value;
    }
    
    public K getKey() {
        return this.key;
    }
    
    public V getValue() {
        return this.value;
    }
    
    public void setKey(K _key) {
        this.key = _key;
    }
    
    public void setValue(V _value) {
        this.value = _value;
    }  
}