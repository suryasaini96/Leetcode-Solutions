class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        String op = "+-/*";
        for (String str: tokens) {
        	if (op.contains(str)) { // it is an operand
        		int b = stack.pop();
                int a = stack.pop();
                int res = evaluate(a,b, str.toCharArray()[0]);
                stack.push(res);
        	} else {
        		stack.push(Integer.parseInt(str));
        	}
        }
        return stack.pop();
    }
    
    static int evaluate(int a, int b, char op){
        if (op == '+') return a+b;
        else if (op == '-') return a-b;
        else if (op == '/') return a/b;
        return a*b;
    }
}