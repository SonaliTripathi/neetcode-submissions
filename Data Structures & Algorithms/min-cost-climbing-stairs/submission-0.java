class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp= Arrays.copyOf(cost,n+1);
        int m=dp.length;

        for(int i=m-3;i>=0;i--){
            dp[i]=Math.min((dp[i]+dp[i+2]),(dp[i]+dp[i+1]));
        }

        return Math.min(dp[0],dp[1]);
        
        
    }

    //TC = SC= O(n)
}
