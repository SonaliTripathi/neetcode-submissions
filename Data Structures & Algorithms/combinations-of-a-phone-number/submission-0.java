class Solution {
    String[] digitToString = {"","","abc","def","ghi",
    "jkl","mno","pqrs","tuv","wxyz"};
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0){
            return res;
        }
        int i=0;
        String currString="";
        backtrack(i,currString,digits);
        return res;
    }

    public void backtrack(int i,String currString,
    String digits){
        if(currString.length()==digits.length()){
            res.add(currString);
            return;
        }
        String chars = digitToString[digits.charAt(i)-'0'];
        for(char c : chars.toCharArray()){
            backtrack(i+1,currString+c,digits);
        }
    }

}

//TC=n*4^n
//Space storage=n
//output space = n*4^n
