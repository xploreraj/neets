class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) return 0;

        // either buy or sell, for each day find profit
        int maxprofit = 0;
        int buy = prices[0];
        for(int i=1; i< prices.length; i++) {
            maxprofit = Math.max(maxprofit, prices[i] - buy);
            buy = Math.min(prices[i], buy);
        }
        return maxprofit;
    }
}
