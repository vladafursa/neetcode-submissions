class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){

            if(prices[i]>max){
                max=prices[i];
            }

            if(prices[i]<=min){
                min=prices[i];
                max=Integer.MIN_VALUE;
                
            }

            if(max!=Integer.MIN_VALUE && min!=Integer.MAX_VALUE){
                maxProfit = Math.max(max-min, maxProfit);
            }
        }
        
        return maxProfit;
    }
}
