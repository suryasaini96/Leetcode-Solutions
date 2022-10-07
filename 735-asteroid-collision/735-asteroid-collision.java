class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            while (!stack.isEmpty() && getDir(stack.peek()) > 0 && getDir(current) < 0) {
                int top = Math.abs(stack.peek());
                int ast = Math.abs(current);
                int res = 0, dir = 0;
                if (top > ast) {
                    res = top;
                    dir = getDir(stack.pop()); 
                    res *= dir;
                } else if (ast > top) {
                    res = ast;
                    dir = getDir(current);
                    res *= dir;
                    stack.pop();
                } else {
                    stack.pop();
                }
                current = res;
            }
            if (current != 0)
                stack.push(current);
        }
    
        int[] res = new int[stack.size()];
        int k = 0;
        for (int i : stack) {
            res[k++] = i;
        }
        return res;
    }
    
    private int getDir(int num) {
        if (num > 0)
            return 1;
        else if (num < 0)
            return -1;
        return 0;
    }
    
    
}