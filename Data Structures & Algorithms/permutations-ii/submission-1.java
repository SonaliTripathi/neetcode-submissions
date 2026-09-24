class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res= new HashSet<>();
        int idx=0;
        backtrack(nums,idx);
        List<List<Integer>> finalRes = new ArrayList<>(res);
        return finalRes;
        
    }

    public void backtrack(int[] nums, int idx){
        if(idx==nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num : nums){
                perm.add(num);
            }
            res.add(perm);
        }

        for(int i=idx; i<nums.length;i++){
            swap(nums,i,idx);
            backtrack(nums,idx+1);
            swap(nums,i,idx);
        }
    }

    public void swap(int[] nums, int i, int idx){
        int temp;
        temp=nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
    }      
}

//TC=n*n!
//SC=n*n!