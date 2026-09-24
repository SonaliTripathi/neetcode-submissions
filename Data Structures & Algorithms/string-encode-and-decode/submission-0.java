class Solution {

    public String encode(List<String> strs) {
        String en="";
        for(String a : strs){
            int len = a.length();
            en = en + len + "#" + a;
        }
        //System.out.println(en);
        return en;
    }

public List<String> decode(String str) {
        List<String> de = new ArrayList<>();
        int i=0;
        
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1, j+1+length);
            de.add(word);
            i=j+1+length;
        }
        return de;
    }

}
