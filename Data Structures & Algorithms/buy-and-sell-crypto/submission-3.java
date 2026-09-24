class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=1;
        int maxProfit =0;
        while(r<=prices.length-1){
            if(prices[r]>prices[l]){
                maxProfit = Math.max(maxProfit, prices[r]-prices[l]);
            }
            else{
                l=r;
            }
            r++;
        }
        return maxProfit==0 ? 0 : maxProfit;
        
    }
}

//TC=O(n) , SC=O(1)
