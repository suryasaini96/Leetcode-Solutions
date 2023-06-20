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
        for (int i = 0; i < n; i++) {
            int diff = diffIndex[i][0];
            int idx = diffIndex[i][1];
            if (diff == 0) {
                count++;
            } else if (additionalRocks >= diff) {
                additionalRocks -= diff;
                count++;
            }
        }        
        return count;
    }
}