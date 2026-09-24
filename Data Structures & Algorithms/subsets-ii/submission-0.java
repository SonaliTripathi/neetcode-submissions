class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,subset,ans);
        return ans;
    }

    public void backtrack(int[] nums,int i,
        List<Integer> subset,List<List<Integer>> ans){
            
            if(i>=nums.length){
                ans.add(new ArrayList<>(subset));
                return;
            }

            subset.add(nums[i]);
            backtrack(nums,i+1,subset,ans);

            subset.remove(subset.size()-1);
            int idx=i+1;
            while(idx<nums.length && nums[idx]==nums[i]){
                idx++;
            }
            backtrack(nums,idx,subset,ans);

        }
    
}
