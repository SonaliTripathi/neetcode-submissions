class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int[] point : points){
            int dist = point[0]*point[0] +
                       point[1]*point[1];
            minHeap.offer(new int[]{dist,point[0],point[1]});  
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            int[] curr = minHeap.poll();
            res[i][0]=curr[1];
            res[i][1]=curr[2];
        }
        return res;       
    }
}

//nlogk
