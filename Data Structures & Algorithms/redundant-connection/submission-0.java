class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }

        for(int[] edge : edges){
            if(!union(edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[]{0};
    }

    public boolean union(int x,int y){
        int xRoot=find(x);
        int yRoot=find(y);
        if(xRoot==yRoot){
            return false;
        }
        if(rank[xRoot]>rank[yRoot]){
            parent[yRoot]=xRoot;
        }
        if(rank[xRoot]<rank[yRoot]){
            parent[xRoot]=yRoot;
        }
        else{
            parent[xRoot]=yRoot;
            rank[xRoot]++;
        }
        return true;
    } 

    public int find(int node){
        int root=parent[node];
        if(parent[root]!=root){
            return parent[node]=find(root);
        }
        return root;
    }
}
