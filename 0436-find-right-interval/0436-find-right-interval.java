class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeSet<Node> set = new TreeSet<Node>();
        for (int i = 0; i < intervals.length; i++) {
            Node node = new Node(intervals[i][0], i);
            set.add(node);
        }
        
        int res[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Node curr = new Node(intervals[i][1], i);
            Node higher = set.ceiling(curr);
            if (higher != null) {
                res[i] = higher.idx;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}



class Node implements Comparable<Node> {
    int val;
    int idx;
    
    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.val - n.val;
    }
}