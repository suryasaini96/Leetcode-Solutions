class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                num = num * 10 + s.charAt(i) - '0';
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) { // If char is operator
                if (op == '+')
                    stack.push(num);
                else if (op == '-')
                    stack.push(-num);
                else if (op == '*')
                    stack.push(stack.pop() * num);
                else if (op == '/')
                    stack.push(stack.pop() / num);
                op = s.charAt(i);
                num = 0;
            }
        }
        
        int ans = 0;
        for (int n: stack) {
            ans += n;
        }
        return ans;
    }
}