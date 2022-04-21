class Solution {
    public String convertToTitle(int columnNumber) {
        int n = columnNumber;
        StringBuilder ans= new StringBuilder();
        while(n>0)
        {
            --n;
            int d= n%26;
            n/=26;
            ans.append((char)('A'+d));            
        }
        ans.reverse();
        return ans.toString();
    }
}