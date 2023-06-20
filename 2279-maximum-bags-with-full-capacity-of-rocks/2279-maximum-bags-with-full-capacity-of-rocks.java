class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[][] diffIndex = new int[n][2];
        
        for (int i = 0; i < capacity.length; i++) {
            int diff = capacity[i] - rocks[i];
            diffIndex[i][0] = diff;
            diffIndex[i][1] = i;
        }
        
        Arrays.sort(diffIndex, (a, b) -> Integer.compare(a[0], b[0]));
        
        int count = 0;
        for (int i = 0; i < n && additionalRocks >= diffIndex[i][0]; i++) {
            count++;
            additionalRocks -= diffIndex[i][0];            
        }        
        return count;
    }
}