class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> minheap = new PriorityQueue<>(Comparator.comparing(a-> a[0]));
        int dist=0;
        int[][] ans = new int[k][2];
        for(int[] point : points){
            int x1=point[0];
            int y1=point[1];
            int x2=0, y2=0;
            int x = x1-x2, y =y1-y2;
            dist = x*x + y*y;
            minheap.offer(new int[]{dist,x1,y1});
        }
        for(int i=0;i<k;i++){
            int[] point = minheap.poll();
            ans[i]= new int[]{point[1],point[2]};
        }
        return ans;

    }
}
//TC = n log n
//SC = n
