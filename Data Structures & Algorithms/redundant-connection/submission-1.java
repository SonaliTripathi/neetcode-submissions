class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        rank = new int[edges.length+1];
        parent = new int[edges.length+1];

        for(int i=0;i<edges.length+1;i++){
            parent[i]=i;
        }

        for(int[] edge : edges){
            if(!union(edge[0],edge[1])){
                return new int[] {edge[0],edge[1]};
            }
        }
        return new int[]{};
    }

    public boolean union(int x,int y){
        int px = findParent(x);
        int py = findParent(y);

        if(px == py){
            return false;
        }

        if(rank[px]<rank[py]){
            parent[px]=py;
        }
        else if(rank[py]<rank[px]){
            parent[py]=px;
        }
        else{
            parent[px]=py;
            rank[py]++;
        }
        return true;
    }

    public int findParent(int node){
        int root = parent[node];

        if(parent[root]!=root){
            return parent[node] = findParent(root);
        }
        return root;
    }
}

//TC:Once you have path compression, subsequent find operations are nearly O(1)
//Since there are exactly n edges (where n = edges.length), we perform n union operations total
//So overall: O(n · α(n)), which is effectively O(n) in practice

//parent =n, rank =n, SC : n
