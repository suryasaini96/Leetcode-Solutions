class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (char ch: words[i].toCharArray()) {
                mask[i] |= 1 << (ch - 'a');
            }
            for (int j = 0; j < i; j++) {
                if ((mask[i] & mask[j]) == 0) { // No letter in common
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}