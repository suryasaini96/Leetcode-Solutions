class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0, start = 0;
        int n = customers.length;
        int window = minutes;
        int k = 0;
        int l = 0;
        for (int end = window - 1; end < n; end++) {
            int j = start;
            int sum = 0;
            while (j <= end) {
                if (grumpy[j] == 1)
                    sum += customers[j];
                j++;
            }
            if (sum > max) { // Found a new max window where I should apply grumpy technique 
                k = start;
                l = end;
                max = sum;
            }
            start++;
        }
        
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (grumpy[i] == 0) {
                res+= customers[i];
            }
        }
        for (int i = l + 1; i < n; i++) {
            if (grumpy[i] == 0) {
                res+= customers[i];
            }
        }
        for (int i = k; i <= l; i++) {
            res+= customers[i];
        }
        
        return res;
    }
}