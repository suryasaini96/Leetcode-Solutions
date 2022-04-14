class Solution {
    public int fib(int n) {
        int a = 0, b = 1;
        int i = 0;
        while (i < n) {
            int temp = b + a;
            a = b;
            b = temp;
            i++;
        }
        return a;
    }
}