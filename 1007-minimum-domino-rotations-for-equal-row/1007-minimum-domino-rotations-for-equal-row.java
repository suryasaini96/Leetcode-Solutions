class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        for (int i = 0, a = 0, b = 0; i < n && (tops[i] == tops[0] || bottoms[i] == tops[0]); ++i) {
            if (tops[i] != tops[0]) a++;
            if (bottoms[i] != tops[0]) b++;
            if (i == n-1) return Math.min(a, b);
        }
        
        for (int i = 0, a = 0, b = 0; i < n && (tops[i] == bottoms[0] || bottoms[i] == bottoms[0]); i++) {
            if (tops[i] != bottoms[0]) a++;
            if (bottoms[i] != bottoms[0]) b++;
            if (i == n-1) return Math.min(a, b);
        }
        return -1;
    }
}
