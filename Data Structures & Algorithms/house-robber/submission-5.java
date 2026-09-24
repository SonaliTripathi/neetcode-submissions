//Memoization
// class Solution {
//     int[] dp;
//     public int rob(int[] nums) {
//         int n=nums.length;
//         dp = new int[n];
//         Arrays.fill(dp,-1);
        
//         return dfs(nums,n-1);
//     }

//         public int dfs(int[] nums,int i){
//             if(i==0){
//                 return nums[0];
//             }
//             if(i<0){
//                 return 0;
//             }
//             if(dp[i]!=-1){
//                 return dp[i];
//             }
//            //int pick=Math.max(nums[i]+dfs(nums,i-2),dfs(nums,i-1));
//             int pick = nums[i]+dfs(nums,i-2);
//             int notpick=dfs(nums,i-1);
//             dp[i]=Math.max(pick,notpick);
//             return dp[i];
//         }
// }

// //Tabulation
class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        dp = new int[n];
        
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
           dp[i]=Math.max(nums[i]+dp[i-2], dp[i-1]);
        }        
        return dp[nums.length-1];
    } 
}


//Space complexity
// class Solution {
//     public int rob(int[] nums) {
//         int n=nums.length;
//         if(n==1){
//             return nums[0];
//         }
        
//         int prev=nums[0];
//         int prev1=Math.max(nums[0],nums[1]);
//         for(int i=2;i<n;i++){
//            int pick = nums[i];
//            if(i>1){
//             pick=pick+prev;
//            }
//            int notpick=prev1;
//            int curri=Math.max(pick,notpick);
//            prev=prev1;
//            prev1=curri;
//         }        
//         return prev1;
//     } 
// }

