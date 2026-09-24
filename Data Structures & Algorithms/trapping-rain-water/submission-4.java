class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int leftmax = height[l];
        int rightmax = height[r];
        int res=0;

        while(l<r){
            if(leftmax<rightmax){
                l++;
                leftmax = Math.max(leftmax,height[l]);
                res=res+leftmax-height[l];
            }
            else{
                r--;
                rightmax = Math.max(rightmax,height[r]);
                res=res+rightmax-height[r];
            }
        }
        return res;
        
    }
}

//n //1
