package BestTimetoBuyandSellStockII;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Solution {
	public int maxProfit(int[] prices) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		boolean buy = false;
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				if (prices[i] <= prices[i + 1]) {
					buy = true;
				} else {
					buy = false;
				}
				continue;
			}
			if (i == prices.length - 1) {
				if (buy == true) {
					profit += prices[i] - prices[i - 1];
				}
				continue;
			}
			if (buy == true) {
				profit += prices[i] - prices[i - 1];
				buy = false;
			}
			if (prices[i] <= prices[i + 1]) {
				buy = true;
			} else {
				buy = false;
			}
		}
		return profit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] prices1 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(s.maxProfit(prices1));
		int[] prices2 = new int[] { 1, 2, 3, 1, 1 };
		System.out.println(s.maxProfit(prices2));
		int[] prices3 = new int[] { 1, 2 };
		System.out.println(s.maxProfit(prices3));
		int[] prices4 = new int[] { 2, 1, 1, 2, 1 };
		System.out.println(s.maxProfit(prices4));
	}

}
