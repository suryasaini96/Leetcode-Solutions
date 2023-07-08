class Solution {
    public int maxScore(int[] nums) {
        int len = nums.length, k = 0, MOD = 1000000007;
        long[] prefix = new long[len];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> zero = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) neg.add(nums[i]);
            else if (nums[i] == 0) zero.add(nums[i]);
            else if (nums[i] > 0) pos.add(nums[i]);
        }
        Collections.sort(neg, (a, b) -> b - a);
        for (int i = 0; i < pos.size(); i++) {
            prefix[k++] = pos.get(i); 
        }
        for (int i = 0; i < zero.size(); i++) {
            prefix[k++] = zero.get(i); 
        }
        for (int i = 0; i < neg.size(); i++) {
            prefix[k++] = neg.get(i); 
        }
        
        int score = prefix[0] > 0 ? 1 : 0;
        prefix[0] = prefix[0] % MOD;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i] % MOD + prefix[i-1];
            if (prefix[i] > 0)
                score++;
        }
        return score;
    }
}