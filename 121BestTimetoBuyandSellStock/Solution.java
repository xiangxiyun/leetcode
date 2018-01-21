public class Solution {
	public static void main(String[] args){
		int[] prices = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		int res = maxProfit2(prices);
		System.out.println(res);

	}

    private static int maxProfit(int[] prices) {
    	/*brute force
    	* O(nn)
    	*/
        int res = 0;

        for(int i = 0; i < prices.length; i++){
        	for(int j = i+1; j < prices.length; j++){
        		int profit = prices[j] - prices[i];
        		if( profit > res){
        			res = profit;
        		}
        	}
        }
        return res;
    }

    private static int maxProfit2(int[] prices){
    	/* Enhanced version of maxProfit
    	* O(n)
    	*/
    	int max_profit = 0;
    	int min_buy = prices[0];

    	for(int sell:prices){
    		if(sell < min_buy)
    			min_buy = sell;
    		int profit = sell - min_buy;
    		if(profit > max_profit)
    			max_profit = profit;
    	}
    	return max_profit;
    }

}