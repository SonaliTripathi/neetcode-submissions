class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int l=0, maxf=0,res=0;
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            maxf=Collections.max(map.values());
            if((r-l+1)-maxf>k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            res=Math.max(res, r-l+1);

        }
        return res;
        
    }
}

//26*n - 26 map size, n number of characters in string
//m - map size
