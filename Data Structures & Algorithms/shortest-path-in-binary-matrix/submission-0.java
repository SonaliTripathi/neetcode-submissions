class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int[][] visit = new int[N][N];

        if(grid[0][0]==1 || grid[N-1][N-1]==1){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int [] {0,0,1});
        visit[0][0]=1;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r=curr[0], c=curr[1], len=curr[2];

            for(int[] dir : dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr<0 || nc<0 || nr>=N || nc>=N || grid[nr][nc]==1 || visit[nr][nc]==1){
                    continue;
                }
                if(nr == N-1 && nc==N-1){
                    return len+1;
                }
                q.offer(new int[]{nr,nc,len+1});
                visit[nr][nc]=1;
            }
        }
        return -1;
        
    }
}