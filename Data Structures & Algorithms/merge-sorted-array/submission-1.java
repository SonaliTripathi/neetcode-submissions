class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=nums1.length-1;
        int j=nums2.length-1;
        int k=m-1;

        while(k>=0 && j>=0){
            if(nums1[k]>=nums2[j]){
                nums1[i]=nums1[k];
                k--;
            }else{
                nums1[i]=nums2[j];
                j--;
            }
            i--;
        }
        while(k>=0){
            nums1[i--]=nums1[k--];
        }
        while(j>=0){
            nums1[i--]=nums2[j--];
        }
    }
}
//m+n
//1