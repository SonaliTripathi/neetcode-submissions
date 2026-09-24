class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int l=0,r=len-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]){
                r=mid-1;
            }
            else l=mid+1;
        }
        return -1;
    }
}

//log n
//1
