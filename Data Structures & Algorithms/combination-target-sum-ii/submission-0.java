class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res= new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> comb = new ArrayList<>();
        int total=0;
        dfs(0, candidates, comb, total, target);
        return res;
    }
    public void dfs(int i, int[] candidates, List<Integer> comb,
    int total, int target){
        if(total==target){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(i==candidates.length || total>target){
            return;
        }

        comb.add(candidates[i]);
        dfs(i+1,candidates,comb,total + candidates[i],target);

        comb.remove(comb.size()-1);
        while(i+1<candidates.length && candidates[i+1]==candidates[i])
        {
            i++;
        }
        dfs(i+1,candidates,comb,total,target);
    }
}
