class Solution {
    public String getHappyString(int n, int k) {
        String base = "abc";
        List<String> ans = new ArrayList<>();
        generateStrings("", base, n, ' ', ans);
        if (k <= ans.size())
            return ans.get(k-1);
        return "";
    }
    
    public void generateStrings(String res, String base, int n, char prev,
                                       List<String> ans) {
        if (res.length() == n) {
            ans.add(res);
            return;
        }
        
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            if (c != prev) {
                generateStrings(res + c, base, n, c, ans);
            }
        }
    }
}