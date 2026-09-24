//n solution - dequeue

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0;
        int n=nums.length;
        Deque<Integer> q = new LinkedList<>();
        int[] output= new int[n-k+1];

        for(int r=0;r<nums.length;r++){
            while(!q.isEmpty() && nums[r]>nums[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(r);

            if(q.peekFirst()<l){
                q.pollFirst();
            }
            if(r-l+1 == k){
                output[l]=nums[q.peekFirst()];
                l++;
            }
            
        }
        return output;

    }
}   

//n

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int l=0;
//         List<Integer> res = new ArrayList<>();
//         for(int r=0;r<nums.length;r++){
            
//             if(r-l+1==k){
//                 int max=Integer.MIN_VALUE;
//                 for(int i=l;i<=r;i++){
//                     max = Math.max(max, nums[i]);
                    
//                 }
//                 res.add(max);
//                 l++;
//             }
            
//         }
//         int[] array = res.stream().mapToInt(i -> i).toArray();
//         return array;
//     }
// }

     
