//find mid
//identify the sorted half from mid 
//. ---array[0] < array[mid] -sorted
// ----array[high] > array[mid] - sorted
// check on the sorted half - if not there, eliminate the sorted half, 
//and check on the second half - which will also have one sorted and one 
//non-sorted




class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(target==nums[mid]){
                return mid;
            }
            //left sorted array
            if(nums[l]<=nums[mid]){
                if(target>nums[mid] || target<nums[l]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            //right sorted array
            else{
                if(target<nums[mid] || target>nums[r]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
        }    
        return -1;        
    }
}
