class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int len = s.length();
            sb.append(len).append('#').append(s);
        }
        return sb.toString();
    }
    //5#Hello5#World
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            String s = str.substring(j+1, j+1+len);
            res.add(s);
            i=j+1+len;
        }
      return res;
    }
}
//n
//n


