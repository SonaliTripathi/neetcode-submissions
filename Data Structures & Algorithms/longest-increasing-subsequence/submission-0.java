class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int res = dfs(nums,0,-1,n);
        return res;
        
    }
    public int dfs(int[] nums, int idx, int prev_idx, int n){
        if(idx==n){
            return 0;
        }
        if(dp[idx][prev_idx+1]!=-1){
            return dp[idx][prev_idx+1];
        }
        int notTake = 0+dfs(nums,idx+1,prev_idx,n);
        int take=0;
        if(prev_idx==-1 || nums[prev_idx]<nums[idx])
        take = 1+dfs(nums,idx+1,idx,n);
        int len =0;
        len = Math.max(take,notTake);
        return dp[idx][prev_idx+1]=len;

    }
}
