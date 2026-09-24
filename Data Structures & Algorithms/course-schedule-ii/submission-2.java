class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        //1. Adj initialize and value stored
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        //2. indegree array stored
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        //3. add all nodes to queue whose indegree is 0
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] res = new int[V];
        int i=0;
        //4. Traverse queue, pop, and make indegree-- of adj nodes of popped node
        while(!q.isEmpty()){
            int course = q.poll();
            res[i++] = course;
            for(int edge : adj.get(course)){
                indegree[edge]--;
                if(indegree[edge]==0){
                    q.offer(edge);
                }
            }
        }
        //5. If res size is not equal to initial numCourses size, then somehwere there was a loop 
        //and couldnt complete all the courses, return empty array
        if(i != V){
            return new int[]{};
        }
        return res;
        
    }
}
//V+E
//V+E


