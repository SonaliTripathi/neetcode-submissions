//find mid
//identify the sorted half
//take minimum from sorted half and eliminate the sorted half
//do the same on the non-sorted portion of the array
// -- store minimum from that, and eliminate the sorted part , them move to second half


class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        int res=Integer.MAX_VALUE;

        while(l<=r){
            int mid = (l+r)/2;
            //checking if left array is sorted, if yes, take min and eleminate,
            //and go to the right half
            if(nums[l]<=nums[mid]){
                res = Math.min(res, nums[l]);
                l=mid+1;
            }
            //else if right array is sorted, take min and eleminate,
            //and go to the left half
            else{
                res = Math.min(res, nums[mid]);
                r=mid-1;
            }
        }
        return res;
    }
}

//logn //1
