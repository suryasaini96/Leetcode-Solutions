class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length()-1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) { // If digit is odd then take all values to left of digit
                return num.substring(0, i+1);
            } 
        }
        return "";
    }
}