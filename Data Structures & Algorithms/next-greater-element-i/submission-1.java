// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] res = new int[nums1.length];

//         for(int i=0;i<nums1.length;i++){
//             int target = nums1[i];
//             int j=0;
//             while(nums2[j]!=target){
//                 j++;
//             }
//             int k=j+1;
//             while(k<nums2.length && nums2[k]<=target){
//                 k++;
//             }
//             if(k<nums2.length){
//                 res[i]=nums2[k];
//             }
//             else{
//                 res[i]=-1;
//             }           
//         }
//         return res;
//     }
// }

//n2 //1

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);

        Stack<Integer> stack = new Stack<>();

        for(int j=0;j<nums2.length;j++){
            while(!stack.isEmpty() && stack.peek()<nums2[j]){
                int val = stack.pop();
                int idx = map.get(val);
                res[idx]=nums2[j];
            }
            if(map.containsKey(nums2[j])){
                stack.push(nums2[j]);
            }
        }
        return res;
    }
}

//n+m
//n
