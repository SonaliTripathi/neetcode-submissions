class Solution {
    List<List<String>> res;
    List<String> partition;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        partition = new ArrayList<>();

        backtrack(s, partition);
        return res;   
    }
    public void backtrack(String s,List<String> partition){
        if(s.length()==0){
            res.add(new ArrayList<>(partition));
        }
        for(int i=0;i<s.length();i++){
            String part=s.substring(0,i+1);
            if(ispalindrome(part)){
                partition.add(part);
                backtrack(s.substring(i+1),partition);
                partition.remove(partition.size()-1);
            }
        } 
    }

    public boolean ispalindrome(String part){
        int l=0,r=part.length()-1;
        while(l<=r){
            if(part.charAt(l)!=part.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return true;
    }
}

//TC=n*2^n-1
//SC=n*2^n-1
