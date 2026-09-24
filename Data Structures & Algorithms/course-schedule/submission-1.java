class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int V=numCourses;
        boolean visited[]= new boolean[V];
        boolean recStack[]= new boolean[V];
        List<Integer>[] adj = new ArrayList[V];
        
        adj = contructAdj(V,adj,prerequisites);

        for(int i=0;i<V;i++){
            if(!visited[i] && isCycle(i,adj,visited,recStack)){
                return false;
            }
        }

        return true;

    }

    public List<Integer>[] contructAdj(int V, List<Integer>[] adj,
    int[][] prerequisites){
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] edge : prerequisites){
            int course1=edge[0];
            int course2=edge[1];
            adj[course2].add(course1);    
        }
        return adj;
    }

    public boolean isCycle(int i,List<Integer>[] adj,boolean[] visited,
    boolean[] recStack){

        if(recStack[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }

        visited[i]=true;
        recStack[i]=true;

        for(int neighbour : adj[i]){
            if(isCycle(neighbour,adj,visited,recStack)){
                return true;
            }
        }

        recStack[i]=false;
        return false;
    }
}
