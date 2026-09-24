class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums,0,ans,subset);
        return ans;
    }

    public void dfs(int[] nums,int i,List<List<Integer>> ans,
    List<Integer> subset){
        if(i==nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums,i+1,ans,subset);

        subset.remove(subset.size()-1);
        dfs(nums,i+1,ans,subset);
    }
}
//n*2^n
//n = Space , for recursive stack
//n*2^n = space, for output ans
