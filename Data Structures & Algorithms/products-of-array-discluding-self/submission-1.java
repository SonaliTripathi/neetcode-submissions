class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Prefix
        int[] prefix = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0) {
                prefix[i]=1;
            }
            else{
                prefix[i]=prefix[i-1] * nums[i-1];
            }
        }
        //Postfix
        int[] postfix = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1) {
                postfix[i]=1;
            }
            else{
                postfix[i]=postfix[i+1] * nums[i+1];
            }
        }
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=prefix[i]*postfix[i];
        }
        return res;
    }
}  
