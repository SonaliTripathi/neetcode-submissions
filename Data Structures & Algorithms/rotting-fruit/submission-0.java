class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time=0;
        int fresh=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,time});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[][] directions ={{1,0},{-1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0], c=curr[1]; 
            time=curr[2];

            for(int[] dir : directions){
                int nr= r+dir[0], nc=c+dir[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols
                && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc,time+1});
                }
            }
        }

        return fresh==0 ? time : -1;
    }
}
