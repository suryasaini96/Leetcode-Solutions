class Solution {
    public int edgeScore(int[] edges) {
        int maxNode = Integer.MAX_VALUE;
        long maxScore = Long.MIN_VALUE;
        long score;
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            score = map.getOrDefault(edges[i], 0L) + i;
            if(score > maxScore){
                maxScore = score;
                maxNode = edges[i];
            }else if(score == maxScore && edges[i] < maxNode){
                maxNode = edges[i];
            }
            map.put(edges[i], score);
        }
        return maxNode;
    }
}