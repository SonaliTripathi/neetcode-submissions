class MyStack {
    public Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
        
    }
    
    public void push(int x) {
        q.offer(x);
        for(int i=q.size()-1;i>0;i--){
            int a = q.poll();
            q.offer(a);
        }
        
        
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
//TC = n,1,1,1
//SC = n

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */