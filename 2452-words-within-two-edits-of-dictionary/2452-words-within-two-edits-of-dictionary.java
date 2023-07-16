class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (addQuery(queries[i], dictionary))
                ans.add(queries[i]);
        }
        return ans;
    }
    
    public boolean addQuery(String query, String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() == query.length()
                && wordDiff(dictionary[i], query) <= 2) {
                return true;
            }
        }
        return false;
    }
    
    public int wordDiff(String a, String b) {
        if (a.length() != b.length()) return 0;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return count;
    }
}