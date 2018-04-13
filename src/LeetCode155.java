class MinStack {

    private Deque<Integer> minStack;
    private Deque<Integer> dataStack;

    public MinStack() {
        minStack = new ArrayDeque<>();
        dataStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.push(x);
        minStack.push((minStack.isEmpty() || x < minStack.peek()) ?
                      x : minStack.peek());
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}



class MinStack {

    private Deque<Integer> minStack;
    private Deque<Integer> dataStack;

    public MinStack() {
        minStack = new ArrayDeque<>();
        dataStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (dataStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        dataStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
