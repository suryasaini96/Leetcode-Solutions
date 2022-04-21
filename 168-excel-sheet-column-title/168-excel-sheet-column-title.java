class Solution {
    public String convertToTitle(int columnNumber) {
        int n = columnNumber;
        StringBuilder result = new StringBuilder();
        while(n>0)
        {
            --n; // Taking 0 based indexing of numbers
            int rem = n % 26;
            n/= 26;
            result.append((char)('A' + rem));
            
        }
        result.reverse();
        return result.toString();
    }
}