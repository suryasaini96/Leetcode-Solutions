class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++){
            int x = num.charAt(i) - '0';            
            while (!stack.isEmpty() && stack.peek() > x && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        
        // If numbers are still in ascending order and k is not 0 yet.
        while(!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        // if (sb.length() == 1) {
        //     return sb.toString();
        // }
        
        // Remove starting 0's
        sb = sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}