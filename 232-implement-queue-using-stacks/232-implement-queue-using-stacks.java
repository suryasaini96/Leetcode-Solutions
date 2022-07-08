class MyQueue {
    
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();
        int popSize = stack.isEmpty()?0:stack.size() - 1;
        while(popSize-- > 0) {
            tempStack.push(stack.pop());
        }
        int res = stack.pop();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return res;
    }
    
    public int peek() {
        Stack<Integer> tempStack = new Stack<>();
        int popSize = stack.isEmpty()?0:stack.size() - 1;
        while(popSize-- > 0) {
            tempStack.push(stack.pop());
        }
        int res = stack.peek();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return res;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */