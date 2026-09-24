class Pair implements Comparable<Pair>{
    int v;
    int w;
    Pair(int v, int w){
        this.v=v;
        this.w=w;
    }

    public int compareTo(Pair that){
        return this.w-that.w;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            int x1=points[i][0];
            int y1=points[i][1];
            for(int j=0;j<n;j++){
                int x2=points[j][0];
                int y2=points[j][1];
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                adj[i].add(new int[]{j,dist});
                adj[j].add(new int[]{i,dist});
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);

        int ans =0;
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u=curr.v;
            int w=curr.w;
            if(vis[u]) continue;
            ans = ans + w;
            vis[u]=true;

            
            for(int[] e : adj[u]){
                int v=e[0];
                int d=e[1];
                if(vis[v]==false){
                pq.offer(new Pair(v,d));
                }
            }
        }
        return ans;

    }
}
