class Solution {
    int[] dp1;
    int[] dp2;
    public int rob(int[] nums) {
        int n=nums.length;
        if (nums.length == 1) return nums[0];
        int[] temp1= Arrays.copyOfRange(nums,0,n-1);
        dp1=new int[temp1.length];
        int[] temp2= Arrays.copyOfRange(nums,1,n);
        dp2=new int[temp2.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        return Math.max((backtrack(temp1,0,dp1)),
        (backtrack(temp2,0,dp2)));
    }

    public int backtrack(int[] temp,int i,int[] dp){
        
        int n=temp.length;
        if(i>=n){
            return 0;
        }
        
        if(dp[i]!=-1) return dp[i];

        int pick=temp[i]+backtrack(temp,i+2,dp);
        int notpick=backtrack(temp,i+1,dp);

        dp[i]=Math.max(pick,notpick);
        return dp[i];
    }
}
