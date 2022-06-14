class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int hmax = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            hmax = Math.max(hmax, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        hmax = Math.max(hmax, h - horizontalCuts[horizontalCuts.length-1]);
        
        int vmax = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            vmax = Math.max(vmax, verticalCuts[i] - verticalCuts[i-1]);
        }
        vmax = Math.max(vmax, w - verticalCuts[verticalCuts.length-1]);
        
        return (int)((long)hmax * vmax % mod);
    }
}