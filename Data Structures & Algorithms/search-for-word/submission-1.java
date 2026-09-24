class Solution {
    int rows;
    int cols;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        rows =board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(dfs(r,c,board,word,0)){
                    return true;
                }
                   
            }
        }
        return false;
    }
    //int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}}
    public boolean dfs(int r, int c, char[][] board, String word,int k){
        if(k==word.length()){
            return true;
        }

        if(r<0 || c<0 || r>=rows || c>=cols || visited[r][c] 
        || board[r][c]!=word.charAt(k)){
            return false;
        }

        visited[r][c]=true;
            
        boolean res = dfs(r+1,c,board,word,k+1) ||
        dfs(r,c+1,board,word,k+1) ||
        dfs(r-1,c,board,word,k+1) ||
        dfs(r,c-1,board,word,k+1);
        

        visited[r][c]=false;

        return res;
    }
}

//m*n*4^L
//L = recursive stack, //m*n = visited matrix
