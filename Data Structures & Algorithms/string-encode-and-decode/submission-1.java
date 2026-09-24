class Solution {

    public String encode(List<String> strs) {
        StringBuilder en = new StringBuilder();
        for(String str : strs){
            int len = str.length();
            en.append(len).append('#').append(str);
        }
        return en.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            String de = str.substring(j+1,j+1+len);
            res.add(de);
            i=j+1+len;
        }
        return res;

    }
}
//n
//n


