class Solution {

public List<int[]>[] constructAdj(int n, int[][] flights){
    List<int[]>[] adj = new ArrayList[n];
    for(int i=0;i<n;i++){
        adj[i] = new ArrayList<>();
    }
    for(int[] f : flights){
        int u=f[0], v=f[1], w=f[2];
        adj[u].add(new int[]{v,w});
    }
    return adj;
}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = constructAdj(n,flights);

        int dist[]= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        int[] temp = new int[n];
        for(int i=0;i<k+1;i++){
            temp = Arrays.copyOf(dist,n);
            for(int[] f : flights){
                int u=f[0], v=f[1], w=f[2];
                if(dist[u]!=Integer.MAX_VALUE &&
                dist[u]+w < temp[v]){
                    temp[v]=dist[u]+w;
                }
            }
            dist=temp;
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        else return dist[dst];

    }
}
