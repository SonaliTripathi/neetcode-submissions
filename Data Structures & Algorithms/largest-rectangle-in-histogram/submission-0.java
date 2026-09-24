class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea=0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int nse = i;
                int element = stack.peek();
                stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();

                maxArea = Math.max(maxArea, 
                            heights[element]*(nse-pse-1)); 
                                  
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
                int nse = n;
                int element = stack.peek();
                stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                
                maxArea = Math.max(maxArea, 
                            heights[element]*(nse-pse-1)); 
                
            }

        return maxArea;
    }
}

//TC=SC=O(n)
