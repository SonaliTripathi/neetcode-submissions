class Node{
    Node[] children ;
    boolean eow;

    public Node(){
        children = new Node[26];
        eow=false;
        for(int i=0;i<26;i++){
            children[i]=null;
        }
    }
}

class Solution {
    HashSet<String> res = new HashSet<>();
    boolean[][] visit;
    Node root = new Node();
    public List<String> findWords(char[][] board, String[] words) {
        
        for(String word : words){
            insert(word,root);
        }

        int rows = board.length;
        int cols = board[0].length;
        String wordSoFar="";
        visit = new boolean[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                dfs(board,r,c,root,wordSoFar);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int r, int c,Node node, String wordSoFar){
        int rows = board.length;
        int cols = board[0].length;
        
        if(r<0 || c<0 || r>=rows || c>=cols || visit[r][c])
        {
            return;
        }
        int idx = board[r][c] -'a';
        if(node.children[idx]==null) return;

        
        visit[r][c] = true;
        node = node.children[idx];
        wordSoFar = wordSoFar + board[r][c];
        if(node.eow == true){
            res.add(wordSoFar);
        }

        dfs(board, r+1, c, node, wordSoFar);
        dfs(board, r, c+1, node, wordSoFar);
        dfs(board, r-1, c, node, wordSoFar);
        dfs(board, r, c-1, node, wordSoFar);

        visit[r][c]=false;
    }

    //insert
    public void insert(String word, Node root){        
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }
}
