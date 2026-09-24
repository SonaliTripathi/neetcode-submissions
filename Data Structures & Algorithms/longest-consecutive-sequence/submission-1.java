// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Arrays.sort(nums);
//         int count=1;
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i+1]-nums[i]==1){
//                 count++;
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }
        int max = 0;
        //int len=0;
        for(int i=0;i<nums.length;i++){
            if(!s.contains(nums[i]-1)){
                int length=1;
                while(s.contains(nums[i]+length)){
                    length++;
                }
                max= Math.max(max,length);
            }
        }
        return max;
    }
}

