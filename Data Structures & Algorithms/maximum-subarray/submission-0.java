class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int currsum =0;

        for(int num : nums){
            currsum = currsum + num;
            if(currsum > maxsum){
                maxsum= currsum;
            }
            if(currsum < 0){
                currsum=0;
            }
        }
        return maxsum;    
    }
}

//n
//1