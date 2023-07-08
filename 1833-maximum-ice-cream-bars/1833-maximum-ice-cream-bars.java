class Solution {
    public int maxIceCream(int[] costs, int coins) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < costs.length; i++) {
            map.put(costs[i], map.getOrDefault(costs[i], 0) + 1);
        }
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key <= coins) {
                for (int i = 1; i <= value; i++) {
                    if (key <= coins) {
                        coins -= key;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}