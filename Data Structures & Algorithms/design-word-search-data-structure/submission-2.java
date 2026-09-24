class Node{
    Node[] children;
    boolean eow;

    public Node(){
        children = new Node[26];
        this.eow=false;
        for(int i=0;i<26;i++){
            children[i] = null;
        }
    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];            
        }
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, Node root){
        Node curr = root;

        for(int i=j;i<word.length();i++){
            
            if(word.charAt(i)=='.'){
                for(Node child : curr.children){
                    if(child!=null && dfs(word, i+1, child)){
                        return true;
                    }
                }
                return false;
            }
            else{
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx]==null){
                    return false;
                }
                if(i==word.length()-1 && curr.children[idx].eow==false){
                    return false;
                }
                curr=curr.children[idx];
            }
           
    }
    return curr.eow;
        
  }  
  }
