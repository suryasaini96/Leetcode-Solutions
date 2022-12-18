class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int l = numbers[left], r = numbers[right];
            if (l + r == target) {
                return new int[]{left+1, right+1};
            } else if (l + r < target) {
                left++;
            } else if (l + r > target) {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}