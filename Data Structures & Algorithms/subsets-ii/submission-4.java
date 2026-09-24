class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums,0,ans,subset);
        return ans;
        
    }

    public void backtrack(int[] nums,int i, List<List<Integer>> ans,
    List<Integer> subset){
        if(i>=nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums,i+1,ans,subset);

        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i+1]==nums[i]){
            i++;
        }
        backtrack(nums,i+1,ans,subset);

    }
}

//n*2^n
//n*2^n
