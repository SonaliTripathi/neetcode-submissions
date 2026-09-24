class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V=numCourses;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];

        for(int i=0;i<V;i++){
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++;
            }
        }

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int[] res = new int[V];
        int index=0;

        while(!q.isEmpty()){
            int node = q.poll();
            res[index++]=node;
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] ==0){
                    q.offer(neighbour);
                }
            }
        }

        if(index!=V){
            return new int[] {};
        }
        else
            return res;
    }

    
}

