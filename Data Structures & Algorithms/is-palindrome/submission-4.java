class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "");
        String s2 = s1.toLowerCase();
        char[] s3 = s2.toCharArray();
        int l=0, r=s3.length-1;
        while(l<r){
            if(s3[l]==s3[r]){
                l++;r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

//n//1
