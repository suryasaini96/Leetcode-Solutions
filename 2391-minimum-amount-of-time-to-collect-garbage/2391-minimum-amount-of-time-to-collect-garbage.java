class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, mIndex = -1, pIndex = -1, gIndex = -1, time = 0;
        for (int i = 0; i <= n - 1; i++) { // Set last indices of P, M, G
            String g = garbage[i];
            time += g.length(); // Collect all garbage
            if (g.contains("M")) mIndex = i;
            if (g.contains("P")) pIndex = i;
            if (g.contains("G")) gIndex = i;
        }
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i-1]; // Prefix sum all travel time to reach index i
        }
        
        time += mIndex >=1 ? travel[mIndex-1] : 0; // Sum travel time to reach last M index
        time += pIndex >=1 ? travel[pIndex-1] : 0; // Sum travel time to reach last P index
        time += gIndex >=1 ? travel[gIndex-1] : 0; // Sum travel time to reach last G index
        return time;
    }

}