class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : nums){
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }
            else
            map.put(a,1);
        }
        
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            list.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            int index= mp.getValue();
            list.get(index).add(mp.getKey());
        }

        int[] res = new int[k];
        int idx=0;
        for(int i=list.size()-1; i>=0 && idx<k;i--){
            for(int num : list.get(i)){
                res[idx++] = num;
                if(idx==k) break;
            }
        }
        return res;
    }
}

