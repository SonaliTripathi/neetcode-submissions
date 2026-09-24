class Disjoint{
    int[] parent;
    int[] rank;
    int n;

    public Disjoint(int n){
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    //Parent Logic- find parent of a node, if parent is not its own parent then it s not the root of the tree, so keep finding the parent of the parent till root is its own parent, in recursion everytime we need to save the ultimate parent for each node in that chain for path compression.
    //Path compression makes the findParent TC to be contant rather than log n.
    public int findParent(int node){
        int root = parent[node];
        if(root != parent[root]){
            return parent[node]=findParent(root);
        }
        return root;
    }

    //Union Logic - if parent of both true, already a component, return false, if not then check rank of each ultimate parent, then merge the smaller rank to higher rank. return true.
    public boolean union(int x,int y){
        int px = findParent(x);
        int py = findParent(y);

        if(px == py){
            return false;
        }

        if(rank[px] > rank[py]){
            parent[py] = px;
        }
        else if(rank[py] > rank[px]){
            parent[px] = py;
        }
        else{
            parent[py] = px;
            rank[px]++;      //If both the ranks are same, then make any one parent of the other and increase the rank of the new parent.
        }
        return true;
    }

}

class Solution {
    public int countComponents(int n, int[][] edges) {

        Disjoint dis = new Disjoint(n);
        int res = n;  // Initially consider n components exist,each is its own parent.
        //reduce components everytime union of two nodes is true, final answer would be like 5(nodes)-3(3 times union was run for 3 edges) = 2 components
        for(int[] edge : edges){
            if(dis.union(edge[0],edge[1])){
                res--;
            }
        }
        return res;

    }
}

//V+E the amortized time for each find/union is:Time = O(V + E × α(V))
//Space = O(V)

