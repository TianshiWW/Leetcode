class MinStack {
    Stack<Integer> minStack, stack;
    int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (!stack.isEmpty()) {
            if(x < minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());        
            }
            stack.push(x);
            
        } else {
            stack.push(x);
            minStack.push(x);    
        }
       
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}