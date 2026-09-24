class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones){
            maxHeap.offer(num);
        }
        while(maxHeap.size()>1){
            int firstheavy=maxHeap.poll();
            int secondheavy=maxHeap.poll();
            if(firstheavy != secondheavy){
            maxHeap.offer(firstheavy - secondheavy);
            }       
        }
        if(maxHeap.size()!=0){
            return maxHeap.poll();
        }
        else return 0;
    }
}
//TC=nlog(n)
