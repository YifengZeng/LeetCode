class MinStack {
public:
    stack<int> dataStack;
    stack<int> minStack;
    MinStack() {

    }

    void push(int x) {
        dataStack.push(x);
        minStack.push((minStack.empty() || x < minStack.top()) ?
                      x : minStack.top());
    }

    void pop() {
        dataStack.pop();
        minStack.pop();
    }

    int top() {
        return dataStack.top();
    }

    int getMin() {
        return minStack.top();
    }
};
