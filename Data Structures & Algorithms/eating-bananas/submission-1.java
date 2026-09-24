class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=Arrays.stream(piles).max().getAsInt();
        int res=r;
        while(l<=r){
            int k=(l+r)/2;
            int hour=0;
            for(int p : piles){
                hour+= Math.ceil((double) p/k);

            }
            if(hour<=h){
                res = Math.min(res,k);
                r=k-1;   
            }
            else{
                l=k+1;
            }
        }
        return res;        
    }
}

//TC=n*log m
//SC=O(1)
