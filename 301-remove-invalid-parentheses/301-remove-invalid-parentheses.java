class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int minRemovals = minRemoveToMakeValid(s);
        List<String> res = new ArrayList<>();
        helper(s, minRemovals, new HashSet<String>(), res);
        return res;
    }
    
    private void helper(String s, int removals, HashSet<String> set, List<String> res) {
        if (removals == 0) {
            if (minRemoveToMakeValid(s) == 0) {
                res.add(s);
            }
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            if (!set.contains(left + right)) {
                set.add(left + right);
                helper(left + right, removals - 1, set, res);
            }  
        }
    }
    
    private int minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                continue;
            else if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty() || s.charAt(stack.peek()) == ')')
                    stack.push(i);
                else
                    stack.pop();
            }
        }
        return stack.size();
     }
}