package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/04/19 10:56 上午
 * 1043. 分隔数组以得到最大和
 */
public class Day046_1043 {
	long res = 0;

	public int maxSumAfterPartitioning(int[] arr, int k) {
		int length = arr.length;
		int[] dp = new int[length];
		for (int i = 1; i <= k; i++) {
			dp[i - 1] = getMaxValue(arr, 0, i - 1) * i;
		}
		for (int i = k; i < length; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i] = Math.max(dp[i - j] + getMaxValue(arr, i - j + 1, i) * j, dp[i]);
			}
		}

		return dp[length - 1];
	}

	private int getMaxValue(int[] arr, int start, int end) {
		int res = 0;
		for (int i = start; i <= end; i++) {
			res = Math.max(res, arr[i]);
		}
		return res;
	}
}
