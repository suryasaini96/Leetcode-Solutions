class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        resultStack.push(new StringBuilder());
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num*10 + (ch-'0');
            } else if (ch == '[') {
                resultStack.push(new StringBuilder());
                countStack.push(num);
                num = 0; // reset the number
            } else if (ch == ']') {
                String internalString = resultStack.pop().toString();
                int noOfTimes = countStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<noOfTimes; j++) {
                    sb.append(internalString);
                }
                resultStack.push(resultStack.pop().append(sb.toString()));
            } else {
                resultStack.peek().append(ch);
            }
        }
        return resultStack.pop().toString();
    }
}