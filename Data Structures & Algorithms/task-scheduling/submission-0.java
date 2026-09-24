class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }
        //Added in maxHeap
        for(int c : count){
            if(c>0){
                maxHeap.offer(c);
            }
        }
        int time=0;
        //Main Logic
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                time=q.peek()[1];
            }
            else{
                int cnt = maxHeap.poll()-1;
                if(cnt>0){
                    q.offer(new int[]{cnt,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                maxHeap.offer(q.peek()[0]);
                q.poll();
            }
        }
        return time;
    }
}

// Counting frequencies → O(n)
// Heap operations → O(26 log 26) → O(1)
// Total → O(n)
