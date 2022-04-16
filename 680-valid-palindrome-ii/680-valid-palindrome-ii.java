class Solution {
    public boolean validPalindrome(String s) {
        boolean skipped = false;
        boolean skippedAgain = false;
        for (int i=0, j=s.length()-1; i<=j; i++, j--) {
            if (s.charAt(i) != s.charAt(j) && skippedAgain) {
                return false;
            } else if (s.charAt(i) != s.charAt(j) && !skipped) { // Try skipping that jth char
                i--;
                skipped = true;
            } else if (s.charAt(i) != s.charAt(j) && skipped) { // Try skipping ith char now if still not equal after skipping jth char
                j = j + 2;
                skippedAgain = true;
            } 
        }
        return true;
    }
}