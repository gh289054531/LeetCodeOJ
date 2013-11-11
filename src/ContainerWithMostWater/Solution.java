package ContainerWithMostWater;

public class Solution {
	/**
	 * 假定左边为l，右边为r，那么l左边的线必须都比l矮，对r也相同
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (height == null || height.length < 2) {
			return 0;
		}
		int l = 0, r = height.length - 1;
		int max = Integer.MIN_VALUE;
		while (l < r) {
			int temp = Math.min(height[l], height[r]) * (r - l);
			if (temp > max) {
				max = temp;
			}
			if (height[l] < height[r]) {
				int i = 1;
				while (l + i < r && height[l] >= height[l + i]) {
					i++;
				}
				l = l + i;
			} else {
				int i = 1;
				while (r - i > l && height[r] >= height[r - i]) {
					i++;
				}
				r = r - i;
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
