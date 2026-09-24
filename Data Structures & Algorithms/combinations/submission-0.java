class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res= new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(1,n,k,comb);
        return res;
    }
    public void dfs(int i,int n,int k,List<Integer> comb){
        
        if(comb.size()==k){
                res.add(new ArrayList<>(comb));
                return;
        }
        if(i>n){
            return;
        }

        comb.add(i);
        dfs(i+1,n,k,comb);
        comb.remove(comb.size()-1);
        dfs(i+1,n,k,comb);
    }
}