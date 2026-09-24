class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0;
        int n = nums.length;
        int[] output = new int[n-k+1];
        
        Deque<Integer> de = new ArrayDeque<>();

        for(int r=0;r<n;r++){
            while(!de.isEmpty() && nums[de.peekLast()]<nums[r]){
                de.pollLast();
            }

            de.addLast(r);

            while(!de.isEmpty() && de.peekFirst()<l){
                de.pollFirst();
            }
            if(r-l+1 ==k){
                output[l]=nums[de.peekFirst()];
                l++;
            }
        }
        return output;
        
    }
}

//n
//n
