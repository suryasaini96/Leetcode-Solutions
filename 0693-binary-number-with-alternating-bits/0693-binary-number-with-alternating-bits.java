class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        char prev = binary.charAt(0);
        for (int i = 1; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == prev)
                return false;
            prev = c;
        }
        return true;
    }
}