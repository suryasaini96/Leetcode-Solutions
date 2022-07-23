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
        
        while(!stack.isEmpty() && k-- > 0){
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        if (sb.length() == 1) {
            return sb.toString();
        }
        
        sb = sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        if (sb.length() == 0) {
            return "0"; 
        }
        
        return sb.toString();
    }
}