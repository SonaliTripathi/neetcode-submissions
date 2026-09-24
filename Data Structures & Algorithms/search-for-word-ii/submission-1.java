class Node{
    Node[] children;
    boolean eow;

    public Node(){
        children = new Node[26];
        this.eow=false;

        for(int i=0;i<26;i++){
            children[i]=null;
        }
    }
}

class Solution {
    Node root;
    Set<String> res;
    int rows,cols;
    boolean[][] visit;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        res = new HashSet<>();
        rows = board.length;
        cols = board[0].length;
        for(String word : words){
            insert(word);
        }

        visit = new boolean[rows][cols];
        String wordsofar="";

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                dfs(board, r, c, root, wordsofar);
            }
        }
        return new ArrayList<>(res);
        
    }

    public void dfs(char[][] board, int r, int c, Node node, String wordsofar){
        if(r<0 || c<0 || r>=rows || c>=cols || visit[r][c]==true){
            return;
        }
        
        int idx = board[r][c] - 'a';
        if(node.children[idx]==null){
            return;
        }

        visit[r][c]=true;
        node = node.children[idx];
        wordsofar = wordsofar + board[r][c];
        if(node.eow == true){
            res.add(wordsofar);
        }

        dfs(board, r+1, c, node, wordsofar);
        dfs(board, r, c+1, node, wordsofar);
        dfs(board, r-1, c, node, wordsofar);
        dfs(board, r, c-1, node, wordsofar);

        visit[r][c]=false;
        
    }

    public void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';

            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            
            curr=curr.children[idx];
        }
        curr.eow = true;
    }
}
