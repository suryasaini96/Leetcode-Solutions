class Solution {
    public long numberOfWays(String s) {
        long totalZeroes = 0, totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                totalZeroes++;
            } else {
                totalOnes++;
            }
        }
        
        long currZeroes = s.charAt(0) == '0' ? 1 : 0;
        long currOnes = s.charAt(0) == '1' ? 1 : 0;
        long count = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                count += currOnes * (totalOnes - currOnes);
                currZeroes++;
            } else {
                count += currZeroes * (totalZeroes - currZeroes);
                currOnes++;
            }
        }
        return count;
    }
}