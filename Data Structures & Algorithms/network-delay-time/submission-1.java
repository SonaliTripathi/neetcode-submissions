class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int mintime = dikshtra(times,n,k);
        return mintime;
        
    }

    public int dikshtra(int[][] times, int n, int k){
        List<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e : times){
            int u=e[0]-1, v = e[1]-1, w=e[2];
            adj[u].add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k-1] = 0;
        pq.offer(new int[]{0,k-1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int w = curr[0];
            int u = curr[1];
            for(int[] nei : adj[u]){
                int v = nei[0];
                int d = nei[1];
                if(w+d < dist[v]){
                    dist[v]=w+d;
                    pq.offer(new int[]{w+d, v});
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}
