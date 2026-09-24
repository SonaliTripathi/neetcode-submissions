class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> perm = new ArrayList<>();
        res = new HashSet<>();
        boolean[] pick = new boolean[nums.length];

        backtrack(nums, perm, pick);
        List<List<Integer>> finalres = new ArrayList<>(res);
        return finalres;
        
    }

    public void backtrack(int[] nums, List<Integer> perm,boolean[] pick){
        if(perm.size()==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                pick[i]=true;
                perm.add(nums[i]);
                backtrack(nums, perm, pick);

                perm.remove(perm.size()-1);
                pick[i]=false;

            }
        }
    }
}
//n*n!
//n*n!
