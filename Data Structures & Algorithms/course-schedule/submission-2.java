class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        int V=numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        //1.Make adj array
        adj= constructAdj(adj,prerequisites,V);

        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycle(i,adj,visited,recStack)){
                     return false;
                }
            }   
        }
        return true;
    }

    //1. Construct Adjacency matrix.
    public List<List<Integer>> constructAdj(List<List<Integer>> adj,int[][] prerequisites,int V){
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre :prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        return adj;
    }

    //2.Detect if a cycle is there
    public boolean isCycle(int i,List<List<Integer>> adj,boolean[] visited,boolean[] recStack){

        if(recStack[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }

        recStack[i]=true;
        visited[i]=true;

        for(int neighbor : adj.get(i)){
            if(isCycle(neighbor,adj,visited,recStack)){
            return true;
            }
        }
        
        recStack[i]=false;
        return false;
    }    
}

//V+E
//V+E
