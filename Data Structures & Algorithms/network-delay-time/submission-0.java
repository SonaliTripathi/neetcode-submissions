class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int minTime = dijkstra(times,n,k); 
        return minTime;

    }
    
    public int dijkstra(int[][] times, int n, int k){

        List<int[]>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e : times){
            int u=e[0]-1, v= e[1]-1, w = e[2];
            adj[u].add(new int[]{v,w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));

        dist[k-1] = 0;
        pq.offer(new int[]{0,k-1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u=curr[1];
            int w=curr[0];
            for(int[] neighbour : adj[u]){
                int v=neighbour[0];
                int d=neighbour[1];
                if(w+d < dist[v]){
                    dist[v]=w+d;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }
        int ans=0;

        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,dist[i]);

        }
        return ans;


    }


}
