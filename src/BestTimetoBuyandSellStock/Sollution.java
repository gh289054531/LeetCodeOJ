package BestTimetoBuyandSellStock;

public class Sollution {
	public int maxProfit(int[] prices) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int high = prices[0], low = prices[0], max = 0;
		boolean up = true;
		for (int i = 0; i < prices.length; i++) {
			if (i == prices.length - 1) {
				if (up == true) {
					high = prices[i];
					max = high - low > max ? high - low : max;
				}
				break;
			}
			if (up == true) {
				if (prices[i + 1] < prices[i]) {
					up = false;
					high = prices[i];
					max = high - low > max ? high - low : max;
				}
			} else {
				if (prices[i + 1] > prices[i]) {
					up = true;
					low = prices[i] < low ? prices[i] : low;
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
