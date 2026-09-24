class Solution {
    public boolean canFinish(int c, int[][] prerequisites) {
        boolean[] visited = new boolean[c];
        boolean[] recstack = new boolean[c];
        List<List<Integer>> adj = new ArrayList<>();

        //1. Make adjacency matrix
        for(int i=0;i<c;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre :prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        //2. Call dfs for every child for a node
        for(int i=0;i<c;i++){
            if(!visited[i]){
                if(isCycle(i,visited,recstack,adj)){
                    return false;
                }
            }
        }
        return true;
    }

    //recstack - if true dfs is still ongoing for that node & viceversa
    //visisted - have i seen this node before?
    public boolean isCycle(int i, boolean[] visited, boolean[] recstack, List<List<Integer>> adj){

        if(recstack[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }

        visited[i]=true;
        recstack[i]=true;

        for(int pre : adj.get(i)){
            if(isCycle(pre,visited,recstack,adj)){
                return true;
            }
        }
        recstack[i]=false;
        return false;
    }
}
