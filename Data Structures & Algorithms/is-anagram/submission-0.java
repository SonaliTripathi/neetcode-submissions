class Solution {
    public boolean isAnagram(String s, String t) {
        char a[]=s.toCharArray();
        Arrays.sort(a);
        char b[]=t.toCharArray();
        Arrays.sort(b);
        Boolean result=Arrays.equals(a,b);

        return result;
        
    }
}
