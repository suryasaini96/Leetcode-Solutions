class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, mIndex = -1, pIndex = -1, gIndex = -1, time = 0;
        for (int i = n - 1; i >= 0; i--) { // Set last indices of P, M, G
            String g = garbage[i];
            if (mIndex == -1 && g.contains("M"))
                mIndex = i;
            if (pIndex == -1 && g.contains("P"))
                pIndex = i;
            if (gIndex == -1 && g.contains("G"))
                gIndex = i;       
        }
        
        // Collect all P
        for (int i = 0; i <= pIndex; i++) {
            String g = garbage[i];
            if (g.contains("P")) {
                int collectTime = getCount(g, 'P');
                time += collectTime;
            }
            if (i > 0)
                time += travel[i-1];  
        }
        
        // Collect all M
        for (int i = 0; i <= mIndex; i++) {
            String g = garbage[i];
            if (g.contains("M")) {
                int collectTime = getCount(g, 'M');
                time += collectTime;
            }
            if (i > 0)
                time += travel[i-1]; 
        }
        
        // Collect all G
        for (int i = 0; i <= gIndex; i++) {
            String g = garbage[i];
            if (g.contains("G")) {
                int collectTime = getCount(g, 'G');
                time += collectTime;
            }
            if (i > 0)
                time += travel[i-1];  
        }
        return time;  
    }
    
    public int getCount(String g, char c) {
        int count = 0;
        for (int i = 0; i < g.length(); i++) {
            if (g.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}