class StockSpanner {
    
    private Stack<Integer> stack;
    private List<Integer> list;

    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int currIndex = list.size();
        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }
        int spanIndex = -1;
        if (!stack.isEmpty())
            spanIndex = stack.peek();
        
        list.add(price);
        stack.push(list.size()-1);
        
        return currIndex - spanIndex;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */