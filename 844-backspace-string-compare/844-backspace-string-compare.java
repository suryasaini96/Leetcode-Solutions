class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
            
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
               stack1.push(s.charAt(i)); 
            }
        }
        
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
               stack2.push(t.charAt(j)); 
            }
        }
        
        // Now pop both the stacks and check if they are equal
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            char a = stack1.isEmpty()?'$':stack1.pop();
            char b = stack2.isEmpty()?'$':stack2.pop();
            if (a != b)
                return false;
        }
        return true;
    }
}