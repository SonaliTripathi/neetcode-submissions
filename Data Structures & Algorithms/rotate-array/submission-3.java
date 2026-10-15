class Solution {
    public void rotate(int[] nums, int k) {
        //two ways to do it
        //First is with extra memory -- Interview Approach
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i+k < nums.length){
                res[i+k] = nums[i];
            }else{
                res[(i+k)%nums.length]=nums[i];
            }   
        }
        System.arraycopy(res, 0, nums, 0, nums.length);

        //2nd way no extra space;
        //Logic - 1. reverse the whole array. 2. reverse from 0-k elements. 3. reverse from k+1 to nums.length elements.
    //     k= k%nums.length;
    //     reverse(nums,0,nums.length-1);
    //     reverse(nums,0,k-1);
    //     reverse(nums,k,nums.length-1);
    // }

    // public int[] reverse(int[] nums, int l, int r){
    //     while(l<r){
    //         int temp=nums[l];
    //         nums[l]=nums[r];
    //         nums[r]=temp;
    //         l++;r--;
    //     }
    //     return nums;
    }


}

//First case - n,n
//Second case - n,1