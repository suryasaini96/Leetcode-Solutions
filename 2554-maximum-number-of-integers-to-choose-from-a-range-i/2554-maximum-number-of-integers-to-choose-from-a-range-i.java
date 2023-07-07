class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedValues = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedValues.add(banned[i]);
        }
        long sum = 0;
        int chosen = 0;
        for (int i = 1; i <= n; i++) {
            if (!bannedValues.contains(i) && sum + i <= maxSum) {
                sum += i;
                chosen++;
            } else if (!bannedValues.contains(i) && sum + i > maxSum) {
                break;
            }
        }
        return chosen;
    }
}