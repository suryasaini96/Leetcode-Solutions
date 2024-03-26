class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int len =  right - left;
            int water = len * Math.min(height[left], height[right]);
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] >= height[right]) {
                right--;
            }
            max = Math.max(max, water);
        }
        return max;
    }
}