class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int target = -nums[i];

            if(i>0 && nums[i]==nums[i-1]) continue;

            int l=i+1, r=nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]==target){
                    finalList.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }
                else if(nums[l]+nums[r]<target) l++;
                else r--;
            }
        }
        return finalList;
        
    }
}
