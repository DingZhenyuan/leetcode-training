class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1 || k == 0) return 0;
        
        int[] buy = new int[k];
        int[] sell = new int[k];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    buy[j] = -prices[0];
                    sell[j] = 0;
                } else {
                    buy[j] = Math.max(buy[j], j == 0 ? -prices[i] : sell[j-1] - prices[i]);
                    sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                }
            }
        }
        return sell[k-1];
    }
}

// better solution
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);   
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
