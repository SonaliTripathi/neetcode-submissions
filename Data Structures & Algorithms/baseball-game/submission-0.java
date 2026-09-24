class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String s : operations){
            if(s.equals("+")){
                int a = stack.pop();
                int b = stack.peek();
                int c = a+b;
                stack.push(a);
                stack.push(c);
            }
            else if(s.equals("C")){
                stack.pop();
            }
            else if(s.equals("D")){
                int d = stack.peek();
                int e = d*2;
                stack.push(e);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            int x = stack.pop();
            sum = sum+x;
        }
        return sum;
    }
}

//n
//n