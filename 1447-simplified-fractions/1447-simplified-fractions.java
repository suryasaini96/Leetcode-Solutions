class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int denom = 2; denom <= n; denom++) {
            for (int nume = 1; nume < denom; nume++) {
                if (gcd(nume, denom) == 1) {
                    String fraction = nume + "/" + denom;
                    ans.add(fraction);
                }
            }
        }
        return ans;
    }
    
    public int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);   
    }
}