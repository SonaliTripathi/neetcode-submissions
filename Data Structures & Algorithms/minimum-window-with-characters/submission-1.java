class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0) return "";

        //created window and tCount map for both
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        //added t count in tCount map
        for(int i=0;i<t.length();i++){
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i),0)+1);
        }

        //SW starts
        int l=0;
        int reslen=Integer.MAX_VALUE;
        int[] res= new int[2];
        int have =0;
        int need = tCount.size();

        for(int r=0;r<s.length();r++){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r),0)+1);

            if(tCount.containsKey(s.charAt(r)) && window.get(s.charAt(r))==tCount.get(s.charAt(r))){
                have++;
            }

            while(have==need){
                if(r-l+1<reslen){
                    reslen = r-l+1;
                    res[0]=l;
                    res[1]=r;
                }

                window.put(s.charAt(l), window.getOrDefault(s.charAt(l),0)-1);
                if(tCount.containsKey(s.charAt(l)) && window.get(s.charAt(l))<tCount.get(s.charAt(l))){
                have--;
                }
                l++;
            }
            
        }
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}

//n + m = n= s parse, m = tcount build
//m

// 🔹 Worst case for window

// Worst case is when all characters are different:

// s = "abcdef..."

// 👉 Map size = number of unique characters

// 🔹 So why O(m)?

// In this problem:

// We only care about characters present in t
// have and need logic is based on tCount

// Even if window stores extra chars (not in t), they don’t affect logic

// 👉 So effectively:

// tCount size = m (unique chars in t)
// window relevant size = m
// 🔹 Important subtlety (interview level)

// Technically:

// window can contain extra characters from s

// So worst-case space could be:

// O(unique characters in s)
// 🔹 But why we still say O(m)?

// Because:

// Only characters in t matter for the algorithm
// Others don’t impact have/need
// Interviewers expect tight bound based on problem constraint
