class Solution {
    public int countSubstrings(String s) {
        int res=0;

        for(int i=0;i<s.length();i++){
            //odd length palindrome
            int l=i, r=i;
            while(l>=0 && r<s.length() && 
            s.charAt(l)==s.charAt(r)){
                res++;
                l--;r++;
            }

            //even length palindrome
            l=i; r=i+1;
            while(l>=0 && r<s.length() && 
            s.charAt(l)==s.charAt(r)){
                res++;
                l--;r++;
            }
        }
        return res;
     
    }
}

//TC=O(n2) //SC=O(1)
