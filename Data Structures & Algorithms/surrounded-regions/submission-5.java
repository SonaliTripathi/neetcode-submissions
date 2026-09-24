class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

         //1. Capture unsurrounded regions
          //Loop for left and right column
          for(int r=0;r<rows;r++){
            capture(r,0,board);
            capture(r,cols-1,board);
          }
          //Loop for top and bottom row
          for(int c=0;c<cols;c++){
            capture(0,c,board);
            capture(rows-1,c,board);
          }

          for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
                else if(board[r][c]=='T'){
                    board[r][c]='O';
                }
            }
          }
    }

    public void capture(int r, int c, char[][] board){
        if(r>=rows || c>=cols || r<0 || c<0 || board[r][c]!='O'){
            return;
        }
        board[r][c]='T';
        capture(r+1,c,board);
        capture(r,c+1,board);
        capture(r-1,c,board);
        capture(r,c-1,board);
    }
}
//m*n - grid size
//m*n - recursion stack is == size of grid
