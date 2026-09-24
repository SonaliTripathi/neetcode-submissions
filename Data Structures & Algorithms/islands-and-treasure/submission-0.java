class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
       int rows=grid.length;
       int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    dfs(i,j,0,grid);
                }
            }
        }
    }

    public void dfs(int i,int j,int count, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length 
        || grid[i][j]<count ){
            return;
        }
        grid[i][j]=count;
        dfs(i+1,j,count+1,grid);
        dfs(i,j+1,count+1,grid);
        dfs(i-1,j,count+1,grid);
        dfs(i,j-1,count+1,grid);

    }
}
