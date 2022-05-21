class Solution {
    // public boolean isPowerOfTwo(int n) {
    //     if (n == 0) return false;
    //     while (n%2==0) n/=2;
    //     if (n == 1) return true;
    //     return false;
    // }
    
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n&(n-1)) == 0;
    }
}