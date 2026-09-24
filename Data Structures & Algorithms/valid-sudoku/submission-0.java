class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.') continue;
                String squareKey = r/3 + "," + c/3;

               if( (rows.computeIfAbsent(r, k -> new HashSet<>()).
                contains(board[r][c]) )||
                (cols.computeIfAbsent(c, k -> new HashSet<>()).
                contains(board[r][c]) ) ||
                (squares.computeIfAbsent(squareKey, k -> new HashSet<>()).
                contains(board[r][c]) )){
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);

            }
        }
        return true;
        
    }
}
//n2
//n2 - “The auxiliary space is O(n²) because we store at most
//n elements for each of n rows, n columns, and n sub-boxes.
//Since Sudoku size is fixed, this is effectively O(1) in practice.”
