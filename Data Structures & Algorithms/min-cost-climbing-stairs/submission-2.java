// class Solution {
//     int[] dp;
//     public int minCostClimbingStairs(int[] cost) {
//         int res=0;
//         dp= new int[cost.length+1];
//         Arrays.fill(dp,-1);
//         int min=Integer.MAX_VALUE;
//         for(int i=0;i<2;i++){
//             res=backtrack(cost,i);
//             min=Math.min(res,min);
//         }
//         return min;
//     }

//     public int backtrack(int[] cost,int i){
//         int n=cost.length;
//         if(i>=n){
//             return 0;

//         }
//         if(dp[i]!=-1) return dp[i];


//         dp[i]= cost[i]+ Math.min(backtrack(cost,i+1),
//         backtrack(cost,i+2));
//         return dp[i];
//     }
//     //TC = SC= O(n)
// }

//Tabulation

class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int res=0;
        dp= new int[cost.length+1];
        Arrays.fill(dp,-1);
        return res=backtrack(cost,0);
    }

    public int backtrack(int[] cost,int i){
        int n=cost.length;
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(i=2;i<n;i++){
            dp[i]=cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    //TC = SC= O(n)
}

