class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int val = nums.length/3;
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : nums){
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }
            else map.put(a,1);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            if(mp.getValue()>val){
                list.add(mp.getKey());
            }
        }
        return list;
        
    }
}