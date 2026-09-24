class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(
            Collections.reverseOrder());
            int diff =0;
        for(int num : stones){
            maxheap.offer(num);
        }
        while(maxheap.size()>1){
            int a = maxheap.poll();
            int b = maxheap.poll();
            if(a!=b){
                diff = Math.max(a,b) - Math.min(a,b);
                maxheap.offer(diff);
            }
        }
        return maxheap.isEmpty() ? 0 : maxheap.peek();
        
    }
}
//TC = n log n
//SC = n
