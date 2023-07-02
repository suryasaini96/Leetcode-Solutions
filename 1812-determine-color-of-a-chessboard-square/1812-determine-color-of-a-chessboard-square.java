class Solution {
    public boolean squareIsWhite(String coordinates) {
        char letter = coordinates.charAt(0);
        int digit = coordinates.charAt(1) - '0';
        int letterDigit = letter - 'a' + 1;
        
        if (letterDigit % 2 == 0 && digit % 2 == 1) {
            // If letterDigit is even and digit is odd
            return true;
        } else if (letterDigit % 2 == 1 && digit % 2 == 0) {
            // If letterDigit is odd and digit is even
            return true; 
        }
        
        return false;
    }
}