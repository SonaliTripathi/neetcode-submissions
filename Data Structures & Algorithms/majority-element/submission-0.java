class Solution {
    public int majorityElement(int[] nums) {
        int val = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : nums){
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }
            else map.put(a,1);
            

        }
        int res=0;
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            if(mp.getValue()>val){
             res = mp.getKey();
            }
        }
        
        return res;
    }
}