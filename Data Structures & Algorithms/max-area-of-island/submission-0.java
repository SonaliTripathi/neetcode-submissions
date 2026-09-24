class Solution {
    int[][] grid;
    int rows, cols;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        this.rows=grid.length;
        this.cols=grid[0].length;
        int count=0;
        int max=0;;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    count=dfs(i,j);
                    max= Math.max(max,count);
                }
            }
        }
        return max; 
    }
    public int dfs(int i,int j){
        if(i<0 || j<0 || i>=rows || j>=cols 
            || grid[i][j]==0){
                return 0;
        }
        grid[i][j]=0;

        int res=1;
        res+=dfs(i,j+1);
        res+=dfs(i+1,j);
        res+=dfs(i-1,j);
        res+=dfs(i,j-1);
        return res;
    }
    
}
