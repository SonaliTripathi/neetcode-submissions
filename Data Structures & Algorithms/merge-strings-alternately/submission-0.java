class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        char[] res = new char[l1+l2];
        int i=0,j=0,k=0;

        while(i<l1 && j<l2){
            res[k++]=word1.charAt(i++);
            res[k++]=word2.charAt(j++);
        }
        while(i<l1){
            res[k++]=word1.charAt(i++);
        }
        while(j<l2){
            res[k++]=word2.charAt(j++);
        }
        String result = new String(res);
        return result;
    }
}
//l1+l2
//l1+l2