class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            sb.append(val);
        }
        
        int ans = 0;
        while (k-- > 0) {
            ans = sumDigits(sb);       
        }
        return ans;
    }
    
    public int sumDigits(StringBuilder sb) {
        int ans = 0;
        for (int i = 0; i < sb.length(); i++) {
            ans += sb.charAt(i) - '0';
        }
        sb.setLength(0);
        sb.append(ans);
        return ans;
    }
}