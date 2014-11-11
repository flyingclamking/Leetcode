//Normal Solution
class MinStack {
    
    private Deque<Integer> stack = new ArrayDeque<Integer>();
    private Deque<Integer> minStack = new ArrayDeque<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


//One Stack Solution
class MinStack {
    
    private Deque<Long> stack = new ArrayDeque<Long>();
    private long min = 0;
    
    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(0L);
            return;
        }
        stack.push(x - min);
        min = Math.min(x, min);
    }

    public void pop() {
        long x = stack.pop();
        if (x <= 0) {
            min -= x;
        }
    }

    public int top() {
        return stack.peek() > 0 ? (int)(min + stack.peek()) : (int)min;
    }

    public int getMin() {
        return (int) min;
    }
}
