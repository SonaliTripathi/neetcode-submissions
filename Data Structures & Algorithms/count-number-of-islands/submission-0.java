class Solution {
    char[][] grid;
    int rows, cols;
    public int numIslands(char[][] grid) {
        this.grid=grid;
        this.rows=grid.length;
        this.cols=grid[0].length;
        int count=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count; 
    }
    public void dfs(int i,int j){
        if(i<0 || j<0 || i>=rows || j>=cols 
            || grid[i][j]=='0'){
                return;
        }
        grid[i][j]='0';
        dfs(i,j+1);
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j-1);
    }
}
