class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar[] = new int[arr.length];
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar[i] = Math.max(max, arr[i]);
            max = maxSoFar[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == maxSoFar[i]) {
                count++;
            }
        }
        return count;
    }
}