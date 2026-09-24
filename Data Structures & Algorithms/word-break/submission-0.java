//Memoization
// class Solution {
//     Map<Integer,Boolean> map;
//     public boolean wordBreak(String s, List<String> wordDict) {
//         map = new HashMap<>();
//         map.put(s.length(),true);
//         int i=0;
//         return dfs(s,wordDict,i);
//     }
//     public boolean dfs(String s, List<String> wordDict,int i){
//         if(map.containsKey(i)){
//             return map.get(i);
//         }

//             for(String w : wordDict){
//                 if((i+w.length())<=s.length() &&
//                     s.substring(i,i+w.length()).equals(w)){
//                         if(dfs(s,wordDict,i+w.length())){
//                             map.put(i, true);
//                             return true;
//                         }
//                 }
//             }
//         map.put(i,false);
//         return false;
//     }
// }

//TC=O(n*m*k) 
//n = length of s
//m = number of words in wordDict
//k = average length of each word
//SC=O(n). Recursion stack:
//In the worst case (e.g., string is all the same character), the recursion could go depth n.


//Tabulation

class Solution {     
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[s.length()]=true;
        for(int i=s.length();i>=0;i--){
            for(String w : wordDict){
                if((i+w.length())<=s.length() &&
                    s.substring(i,i+w.length()).equals(w)){    
                        dp[i]=dp[i+w.length()];
                    }
                        if(dp[i]){
                            break;
                        }
                }
            }
            return dp[0];
        }
}   

//TC=O(n*m*k) //For each index, compare with all words (each up to length k).
//SC=O(n) //Dp array