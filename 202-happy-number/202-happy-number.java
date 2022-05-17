class Solution {
    
    // Using loop detection slow and fast pointer approach
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquare(slow);
            fast = digitSquare(digitSquare(fast));
        } while (slow != fast);
        if (slow == 1) return true;
        return false;
    }
    
    private int digitSquare(int n) {
        int res = 0;
        while (n > 0) {
            int rem = n%10; 
            res += rem*rem;
            n /= 10;
        }
        return res;
    }
}