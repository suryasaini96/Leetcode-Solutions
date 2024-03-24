/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        boolean[] vis = new boolean[101];
        boolean[] updateVis = new boolean[101];
        HashMap<Node, Node> newNodeMap = new HashMap<>();
        Node newHead = dfs(node, vis, newNodeMap);
        updateList(node, updateVis, newNodeMap);
        return newHead;
    }
    
    public Node dfs(Node node, boolean[] vis, HashMap<Node, Node> newNodeMap) {
        if (node == null || vis[node.val]) return null;
        int value = node.val;
        vis[value] = true;
        List<Node> neighbors = node.neighbors;
        Node newNode = new Node(node.val);
        newNodeMap.put(node, newNode);
        for (Node adj : neighbors) {
            dfs(adj, vis, newNodeMap);
        }
        return newNode;
    }
    
    public void updateAdjList(Node node, HashMap<Node, Node> newNodeMap) {
        if (node == null) return;
        Node newNode = newNodeMap.get(node);
        List<Node> newAdjList = new ArrayList<>();
        List<Node> adjList = node.neighbors;
        for (Node adj : adjList) {
            Node newAdjNode = newNodeMap.get(adj);
            newAdjList.add(newAdjNode);
        }
        newNode.neighbors = newAdjList;
    }
    
    public void updateList(Node node, boolean[] updateVis, HashMap<Node, Node> newNodeMap) {
        if (node == null || updateVis[node.val]) return;
        updateVis[node.val] = true;
        updateAdjList(node, newNodeMap);
        List<Node> adjList = node.neighbors;
        for (Node adj : adjList) {
            updateList(adj, updateVis, newNodeMap);
        }
    }
    
    
    
    
}