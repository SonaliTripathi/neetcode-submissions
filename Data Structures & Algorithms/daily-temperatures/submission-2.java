class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]] = i-pair[1];
            }
            stack.push(new int[] {temperatures[i],i});
        }
        return res;
    }
}

//Monotonic decreasing stack logic, pop till the new temperature 
//is greater than the peek temperature.Since in stack we store the 
//index as well with temperature, we subtract the current i from top stack i
//and get the required difference of days in res.

//n 
//n
