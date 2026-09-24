class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","");

        s = s.toLowerCase();
        char[] s1 = s.toCharArray();
        System.out.println(s1);
        int i=0,j=s1.length-1;
        while(i<=j){
            if(s1[i]==s1[j]){
                i++;j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
