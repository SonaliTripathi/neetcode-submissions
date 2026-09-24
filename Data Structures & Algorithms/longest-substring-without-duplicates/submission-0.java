class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l=0,maxlen=0;

        for(int r=0;r<s.length();r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;    
    }
}
//TC=SC=O(n)