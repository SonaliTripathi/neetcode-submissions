class Solution {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int l = 0;
        int r = height.length-1;
        int res=0;
        int leftmax=height[0], rightmax=height[r];
        while(l<r){
            if(leftmax < rightmax){
                l++;
                leftmax = Math.max(leftmax, height[l]);
                res=res+leftmax-height[l];
            }
            else{
                r--;
                rightmax = Math.max(rightmax, height[r]);
                res=res+rightmax-height[r];
            }
        }
        return res;
        
    }
}
//n
//1
