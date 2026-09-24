class Solution {
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        int count=0;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;r--;
            }
            else if(s.charAt(l)!=s.charAt(r)){
                return (palindrome(s.substring(0,l)+ s.substring(l+1))
                || palindrome(s.substring(0,r)+ s.substring(r+1)) );
            }   
            
        }
        return true;
    }

    public boolean palindrome(String s){
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    //n//1
}