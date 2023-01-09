class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openBracket.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBracket.isEmpty() && openBracket.peek() < i) {
                    openBracket.pop();
                } else if (!star.isEmpty() && star.peek() < i) {
                    star.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '*') {
                star.push(i);
            }
        }
        while (!star.isEmpty() && !openBracket.isEmpty()){
            if (star.peek() > openBracket.peek()){
                star.pop(); openBracket.pop();
            } else {
                return false;
            }
        }
        if (!openBracket.isEmpty() && star.isEmpty()) {
            return false;
        }
        return true;
    }
    
    
}