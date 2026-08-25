class MinStack {
    Stack<Integer> myStack;
    Stack<Integer> minStack;
    public MinStack() {
        myStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        myStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (myStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        myStack.pop();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
