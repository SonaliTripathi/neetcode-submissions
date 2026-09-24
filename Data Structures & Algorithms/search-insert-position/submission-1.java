class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target>nums[mid]) l++;
            else r--;
        }
        return l;
        
    }
}