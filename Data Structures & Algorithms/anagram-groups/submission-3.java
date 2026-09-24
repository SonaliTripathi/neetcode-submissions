class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            map.putIfAbsent(sortedString, new LinkedList<>());
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
        
    }
}
//m*nlogn
//n*k - n=numbers of unique keys, k=length of every string