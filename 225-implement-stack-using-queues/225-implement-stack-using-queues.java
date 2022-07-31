class MyStack {
    
    private ArrayDeque<Integer> q;

    public MyStack() {
        this.q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        this.q.add(x);
    }
    
    public int pop() {
        return this.q.pollLast();
    }
    
    public int top() {
        return this.q.peekLast();
    }
    
    public boolean empty() {
        return this.q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */