class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r = Arrays.stream(piles).max().getAsInt();
        int res=r;

        while(l<=r){
            int mid = (l+r)/2;
            int hour =0;

            for(int pile : piles){
                hour += Math.ceil((double)pile/mid);
            }
            if(hour <= h){
                res = Math.min(res, mid);
                r=mid-1;
            }
            else if (hour > h){
                l=mid+1;
            }

        }
        return res;
    }
}
//n * logm
//1
