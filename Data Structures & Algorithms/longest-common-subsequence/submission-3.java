//Memoization
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m=text1.length();
//         int n=text2.length();
//         int[][] dp=new int[m+1][n+1];
//         for(int i=1;i<m+1;i++){
//             for(int j=1;j<n+1;j++){
//                 dp[i][j]=-1;
//             }
//         }
//         int res = backtrack(m,n,text1,text2,dp);
//         return res;
//     }
//     public int backtrack(int m,int n, String text1,String text2,int[][] dp){
//         if(m==0 || n==0){
//             return 0;
//         }
//         if(dp[m][n]!=-1){
//             return dp[m][n];
//         }
//         if(text1.charAt(m-1)==text2.charAt(n-1)){
//            return dp[m][n]=1+backtrack(m-1,n-1,text1,text2,dp);
//         }else{
//             return dp[m][n]=Math.max((backtrack(m-1,n,text1,text2,dp)),
//              (backtrack(m,n-1,text1,text2,dp)));
//         }
//     }
// }

//Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        int res=lcsUtil(m,n,text1,text2,dp);
        return res;
    }
    public int lcsUtil(int m,int n,String text1, String text2,int[][] dp){
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}   

