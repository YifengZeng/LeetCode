class MyStack {

    Deque<Integer> dataQ;
    Deque<Integer> helpQ;
    /** Initialize your data structure here. */
    public MyStack() {
        dataQ = new LinkedList<>();
        helpQ = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        helpQ.offer(x);
        while (!dataQ.isEmpty()) {
            helpQ.offer(dataQ.poll());
        }
        while (!helpQ.isEmpty()) {
            dataQ.offer(helpQ.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return dataQ.poll();
    }

    /** Get the top element. */
    public int top() {
        return dataQ.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return dataQ.isEmpty();
    }
}