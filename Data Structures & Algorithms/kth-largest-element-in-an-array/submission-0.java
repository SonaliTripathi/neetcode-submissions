class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            maxheap.offer(num);
        }
        int res =0;
        for(int i=0;i<k;i++){
            res = maxheap.poll();
        }
        return res;
    }
}
//TC=nlogk
//SC=n
