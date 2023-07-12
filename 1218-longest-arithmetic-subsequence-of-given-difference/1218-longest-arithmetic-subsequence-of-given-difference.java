class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Map --> arr[i], maxLen ending at i
        int maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            int prev = arr[i] - difference;
            if (map.containsKey(prev)) {
                int lenEndingAtCurrent = map.get(prev) + 1;
                maxLen = Math.max(maxLen, lenEndingAtCurrent);
                map.put(arr[i], lenEndingAtCurrent);
            } else {
                map.put(arr[i], 1);
            }
        }
        return maxLen;
    }
}