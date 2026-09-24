class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0){
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr<0 || nr>=rows || nc<0 || nc>=cols || grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }
                q.offer(new int[]{nr,nc});
                grid[nr][nc]= grid[row][col] +1;
            }
        }
        
    }
}

//m*n
//m*n
