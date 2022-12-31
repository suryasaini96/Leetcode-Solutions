class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long[] suffixSums = new long[shifts.length];
        suffixSums[shifts.length-1] = shifts[shifts.length-1];
        for (int i = shifts.length - 2; i>=0; i--) {
            suffixSums[i] = shifts[i] + suffixSums[i+1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            long res = (s.charAt(i) - 'a' + suffixSums[i]) % 26;
            sb.append((char)('a' + res));
        }
        return sb.toString();
    }
}