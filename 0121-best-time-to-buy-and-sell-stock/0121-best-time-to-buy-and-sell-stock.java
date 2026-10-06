class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;

        for(int i = 0; i < n;i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit,profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}