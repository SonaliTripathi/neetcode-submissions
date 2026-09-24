class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        int total=0;
        dfs(0, nums, comb, target,total);
        return res;
    }

    public void dfs(int i, int[] nums, List<Integer> comb, int target, int total){
        if(total==target){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(i>=nums.length || total>target){
            return;
        }

        comb.add(nums[i]);
        dfs(i,nums,comb,target,total+nums[i]);

        comb.remove(comb.size()-1);
        dfs(i+1,nums,comb,target,total);

    }
}

//TC=O(2^t/m)
//SC=O(t/m)
