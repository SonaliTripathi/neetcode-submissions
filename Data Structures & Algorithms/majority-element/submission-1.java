class Solution {
    public int majorityElement(int[] nums) {
        int val = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int res=0;
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            if(mp.getValue()>val){
                res= mp.getKey();
            }
        }
        return res;
    }
}
//n
//n