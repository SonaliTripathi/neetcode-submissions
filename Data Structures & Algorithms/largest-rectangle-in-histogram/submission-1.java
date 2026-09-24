class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea =0;

        for(int i=0;i<heights.length;i++){
            int start = i;

            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int topHeight = top[1];
                maxArea = Math.max(maxArea, topHeight * (i-index));
                start = index;
            }
            stack.push(new int[]{start,heights[i]});
        }

        for(int[] pair : stack){
            maxArea =Math.max(maxArea, (heights.length-pair[0]) * pair[1]);
        }
        return maxArea;
        
    }
}

//n
//n
