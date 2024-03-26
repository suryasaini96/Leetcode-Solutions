class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        if (b < 0) {
            b = Math.abs(b);
            while (b-- != 0) {
                a--;
            }
            return a;
        }
        for (int i = 1; i <= b; i++) {
            a++;
        }
        return a;
    }
}