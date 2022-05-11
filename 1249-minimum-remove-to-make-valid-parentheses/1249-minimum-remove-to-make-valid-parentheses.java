class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
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
        HashSet<Integer> set = new HashSet<>(stack);
        for (int i=0; i<s.length(); i++) {
            if (!set.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
     }
}