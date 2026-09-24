class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        //store count for s1->abc and s2->lec
        for(int i=0;i<s1.length();i++){
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }
        int matches=0;

        //whole 26 length count array parse to calculate initial matches.
        for(int i=0;i<26;i++){
            if(s1Count[i]==s2Count[i]){
                matches++;
            }
        }

        //SW starts by adding a of s2
        int l=0;
        for(int r=s1.length(); r<s2.length();r++){
            if(matches ==26) return true;

            int indexr= s2.charAt(r)-'a';
            s2Count[indexr]++;

            if(s1Count[indexr] == s2Count[indexr]){
                matches++;
            }
            else if(s1Count[indexr]+1 == s2Count[indexr]){
                matches--;
            }

            int indexl = s2.charAt(l)-'a';
            s2Count[indexl]--;

            if(s1Count[indexl] == s2Count[indexl]){
                matches++;
            }
            else if(s1Count[indexl]-1 == s2Count[indexl]){
                matches--;
            }
            l++;

        }
        return matches ==26;        
    }
}

//n
//1
