class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true; // Set all as prime initially
        }
        for (int i = 2; i*i <= n; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i) { // Set multiples of all values greater than square to not prime
                    prime[j] = false; // Not a prime
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) 
                count++;
        }
        return count;
    }
}