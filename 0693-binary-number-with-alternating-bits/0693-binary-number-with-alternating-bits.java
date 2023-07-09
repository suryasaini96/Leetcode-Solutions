class Solution {
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1); // right shift by 1 then XOR 
        // Now & with n + 1 and all values should be zero
        return (n & n + 1) == 0;
        
    }
}