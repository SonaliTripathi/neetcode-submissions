class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
        
    }

    public void mergeSort(int[] nums, int l, int r){
        if(l>=r) return;

        int mid = (l+r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int m, int r){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = l;
        int j = m+1;
        while(i<=m && j<=r){
            if(nums[i]<=nums[j]){
                temp.add(nums[i]);
                i++;
            }
            else{
                temp.add(nums[j]);
                j++;
            }
        }
        while(i<=m){
            temp.add(nums[i]);
            i++;
        }
        while(j<=r){
            temp.add(nums[j]);
            j++;
        }

        for(i=l;i<=r;i++){
            nums[i]=temp.get(i-l);
        }
    }
}

//Merge Sort = nlogn
//n