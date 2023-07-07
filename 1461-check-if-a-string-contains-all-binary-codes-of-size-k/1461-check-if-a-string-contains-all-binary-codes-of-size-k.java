class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = k; i <= s.length(); i++) {
            String str = s.substring(i - k, i);
            set.add(str);
        }
        return set.size() == Math.pow(2, k) ? true : false;
    }
}