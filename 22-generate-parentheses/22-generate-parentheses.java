class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }
    
    private void helper(List<String> list, String str, int left, int right, int n) {
        if (str.length() == n*2) {
            list.add(str);
            return;
        }
        if (left < n)
            helper(list, str + "(", left + 1, right, n);
        if (right < left)
            helper(list, str + ")", left, right+1, n);
    }
}