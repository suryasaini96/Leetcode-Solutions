class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] prevCount = new int[s.length()];
        int topIndex = -1;
        int topCount = 0;
        char topChar = '#';
        for (int i = 0; i < s.length(); i++) {
            topIndex = stack.isEmpty()?-1:stack.peek();
            if (topIndex >= 0) {
                topCount = prevCount[topIndex];
                topChar = s.charAt(topIndex);
            } else {
                topCount = 0;
                topChar = '#';
            }
            
            if (topChar == s.charAt(i) && topCount + 1 == k) {
                prevCount[i] = topCount + 1;
                int count = topCount;
                while (count-- > 0) {
                    stack.pop();
                }     
            } else {
                stack.push(i);
                if (topChar != s.charAt(i)) {
                    prevCount[i] = 1;
                } else {
                    prevCount[i] = topCount + 1;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(s.charAt(stack.pop()));
        }
        return sb.reverse().toString();
    }
}