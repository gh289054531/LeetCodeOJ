package Candy;

/*
 There are N children standing in a line. Each child is assigned a rating value.
 You are giving candies to these children subjected to the following requirements:
 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Solution {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candy = new int[ratings.length];
		for (int i = 0; i < ratings.length; ) {
			for (int left = i; left > 0; left--) {
				if (ratings[left] < ratings[left - 1]) {
					candy[left - 1] = Math.max(candy[left] + 1, candy[left - 1]);
				} else{
					break;
				}
			}
			int right = i;
			for (; right < ratings.length - 1; right++) {
				if (ratings[right] < ratings[right + 1]) {
					candy[right + 1] = Math.max(candy[right] + 1, candy[right + 1]);
				} else{
					break;
				}
			}
			i = right+1;
		}
		int sum = ratings.length;
		for (int i = 0; i < ratings.length; i++) {
			sum += candy[i];
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] test1 = { 3, 2, 1, 2, 3 };
		System.out.println(s.candy(test1));
		int[] test2 = { 4, 7, 2, 1, 5 };
		System.out.println(s.candy(test2));
		int[] test3 = { 0 };
		System.out.println(s.candy(test3));
		int[] test4 = new int[10000];
		for (int i = 0; i < 10000; i++) {
			test4[i] = i;
		}
		System.out.println(s.candy(test4));
		int[] test5 = { 2,2,1};
		System.out.println(s.candy(test5));
	}

}
