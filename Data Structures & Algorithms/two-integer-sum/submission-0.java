class Solution {
    public int[] twoSum(int[] nums, int target) {
    //     int res[]=new int[2];
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i]+nums[j]==target){
    //                 res[0]=i;
    //                 res[1]=j;
    //             }
    //         }
    //     }
    //     return res;
        
      Map<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int diff =target-nums[i];
        if(map.containsKey(diff)){
            return new int[]{map.get(diff),i};
        }
        map.put(nums[i], i);
      }
      return new int[]{};
    }


}
