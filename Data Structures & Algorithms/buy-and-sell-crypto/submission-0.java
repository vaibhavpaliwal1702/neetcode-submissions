class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cheap = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]-cheap > profit){
                profit = prices[i]-cheap;
            }
            if(prices[i]<cheap){
                cheap = prices[i];
            }
        }

        return profit;
    }
}
