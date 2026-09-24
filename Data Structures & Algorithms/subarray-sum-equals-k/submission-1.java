class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0, res=0;
        for(int i=0;i<nums.length;i++){
            sum=nums[i];
            if (sum == k) res++;
            for(int j=i+1;j<nums.length;j++){
                sum = sum+nums[j];
                if(sum==k){
                    res++;
                }
            }
        }
        return res;
    }
}
//n^2
//1