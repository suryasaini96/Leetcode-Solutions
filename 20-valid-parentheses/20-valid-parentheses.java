class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))) {  // it is right bracket
                char c = stack.empty()?'#':stack.pop();
                if (map.get(s.charAt(i)) != c){ 
                    return false;
                }
            } else { // it is left bracket
                stack.push(s.charAt(i));
            }
        }

        if(stack.empty()) return true;
        return false;
    }
}