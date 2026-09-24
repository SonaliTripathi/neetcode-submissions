class Solution {
    public int[] twoSum(int[] nums, int target) {
    int left=0;
    int right=nums.length-1;

    while(left!=right){
        if((nums[left]+nums[right])==target)
        return new int[]{left,right};

        if(target-nums[left]!=nums[right])
        right--;

        if(right==left+1 && (target-nums[left]!=nums[right])){
            left++;
            right=nums.length-1;
        }

    }
    return new int[]{};
}
}
