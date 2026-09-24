class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<List<Integer>> freq = new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            freq.add(new ArrayList<>());
        }
        
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            int idx = mp.getValue();
            freq.get(idx).add(mp.getKey());
        }
        int[] res = new int[k];
        int idx=0;

        for(int i=freq.size()-1;i>=0 && idx<k; i--){
            for(int num : freq.get(i)){
                res[idx++] = num;
                if(idx==k){
                    break;
                }
            }
        }
        return res;
    }
}
