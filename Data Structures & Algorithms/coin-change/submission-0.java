class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        int res = memo(coins,amount);
        return res==Integer.MAX_VALUE ? -1 : res;
        
    }

    public int memo(int[] coins, int amount){
        if(amount==0) return 0;
        int min= Integer.MAX_VALUE;
        int res=0;

        for(int i=0;i<coins.length;i++){
            if(amount-coins[i]>=0){
                int ans =0;
                if(dp[amount-coins[i]]!=-1){
                    ans = dp[amount-coins[i]];
                }
                else{
                    ans = memo(coins, amount-coins[i]);
                }
                if(ans!=Integer.MAX_VALUE){
                    min=Math.min(min,1+ans);
                    }
        }
        }
        dp[amount] = min;
        return dp[amount];
    }
}
