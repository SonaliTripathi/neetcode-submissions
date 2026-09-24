class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        //call dfs for left and right border columns
        for(int r=0;r<rows;r++){
            capture(r,0,board);
            capture(r,cols-1,board);
        }
        //call dfs for top and bottom border rows
        for(int c=0;c<cols;c++){
            capture(0,c,board);
            capture(rows-1,c,board);
        }

        //after dfs, change 0->X and T->O
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
    //dfs to change the border rows and cols to T wherever O is there
    public void capture(int r, int c, char[][] board){
        if(r<0 || c<0 || r>=rows || c>=cols || 
        board[r][c]!='O'){
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
