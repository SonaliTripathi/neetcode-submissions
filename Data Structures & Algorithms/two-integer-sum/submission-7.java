class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(map.containsKey(diff)){
                int j= map.get(diff);
                return new int[] {Math.min(i,j),Math.max(i,j)};
            }

            map.put(nums[i],i);
        }
        return new int[0];
    }
}
