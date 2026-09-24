class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String val = new String(charArr);
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(s);

        }
           
           return new ArrayList<>(map.values());
    }
}
