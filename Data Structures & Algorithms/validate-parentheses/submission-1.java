class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')','(');
        closeToOpen.put('}','{');
        closeToOpen.put(']','[');

        for(char w : s.toCharArray()){
            if(closeToOpen.containsKey(w)){
                if(!stack.isEmpty() && 
                stack.peek()==closeToOpen.get(w)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(w);
            }
        }
        return stack.isEmpty();        
    }
}

//=TC=SC=O(n)