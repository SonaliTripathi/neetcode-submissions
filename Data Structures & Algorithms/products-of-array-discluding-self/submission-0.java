// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] res = new int[nums.length];
        
//         for(int i=0;i<nums.length;i++){
//             int val=1;
//             for(int j=0;j<nums.length;j++){
//                 if(j==i){
//                     continue;
//                 }
//                 else{
//                     val = val*nums[j];
//                 }
//             }
//             res[i]=val;
//         }
//         return res;
// }
// }  

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] postf = new int[n];
        int[] res = new int[n];
        //make prefix array
        for(int i=0;i<n;i++){
            if(i==0){
                pref[0]=nums[i];
            }
            else{
                pref[i]=pref[i-1]*nums[i];
            }
        }
        //make postfix array
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                postf[i]=nums[i];
            }
            else{
                postf[i]=postf[i+1]*nums[i];
            }
        }
        //make result array
        for(int i=0;i<n;i++){
            if(i==0){
                res[i]=1*postf[i+1];
            }
            else if(i==n-1){
                res[i]=pref[i-1]*1;
            }
            else{
                res[i]=pref[i-1]*postf[i+1];
            }
        }
        return res;

        }
}  

