class Disjoint{
    int[] rank;
    int[] parent;
    int n;

    public Disjoint(int n){
        this.n=n;
        parent =new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public int find(int i){
        int root=parent[i];
        if(parent[root]!=root){
            return parent[i]=find(root);
        }
        return root;
    }

    public boolean union(int x,int y){
        int xRoot = find(x);
        int yRoot = find(y);
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
}


class Solution {
    public int countComponents(int n, int[][] edges) {
        Disjoint du = new Disjoint(n);
        int res=n;
        for(int[] edge : edges){
            if(du.union(edge[0],edge[1])){
                res--;
            }
        }
        return res;
    }
}


