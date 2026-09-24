class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res= new ArrayList<>();
        int idx=0;
        backtrack(nums,idx);
        return res;
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

//TC=n!*n
//SC=n!*n
