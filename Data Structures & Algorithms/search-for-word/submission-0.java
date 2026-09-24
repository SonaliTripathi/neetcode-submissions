class Solution {
    Set<Pair<Integer,Integer>> set;
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        set = new HashSet<>();
        rows=board.length;
        cols=board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word,int i,int j,
    int k){  
        if(k==word.length()) return true;

        if(i<0 || i>=rows || j<0 || j>=cols || 
        set.contains(new Pair<>(i,j)) || board[i][j]!= word.charAt(k)){
            return false;
        }
        set.add(new Pair<>(i,j));
        boolean res = dfs(board, word,i+1,j,k+1)
                 ||   dfs(board, word,i-1,j,k+1)
                 ||   dfs(board, word,i,j+1,k+1)
                 ||   dfs(board, word,i,j-1,k+1);

        set.remove(new Pair<>(i,j));    
        return res;    
    }

}
