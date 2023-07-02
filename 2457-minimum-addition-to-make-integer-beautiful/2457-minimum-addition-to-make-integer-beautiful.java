class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        // Approach: Round off the number to nearest tenths place
        // So that one digit is removed and it is easier to reach target as early
        long og = n;
        long base = 1;
        while (getSum(n) > target) {
            n = n / 10 + 1;
            base *= 10;
        }
        return n * base - og;
    }
    
    private long getSum(long n) {
        long sum = 0;
        while (n > 0) {
            long r = n % 10;
            n = n / 10;
            sum += r;
        }
        return sum;
    }
}