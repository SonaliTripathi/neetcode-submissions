class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int time=0;
        int fresh=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }
                else if(grid[r][c]==1){
                    fresh++;
                }
            }
        }

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty() && fresh>0){
            int len = q.size();

            for(int i=0;i<len;i++){
                int[] node = q.poll();
            int r = node[0];
            int c= node[1];
            for(int[] dir : dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr<0 || nc<0 || nr>=rows || nc>=cols || grid[nr][nc]!=1){
                    continue;
                }

                grid[nr][nc]=2;
                q.offer(new int[]{nr,nc});
                fresh--;
            } 
            }           
            time++;
        }
        return fresh==0 ? time : -1;
        
    }
}

//m*n
//m*n
