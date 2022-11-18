package may.leetcode;

import java.util.Arrays;

/**
 * @author liubr
 * @date 2022/11/18 16:47
 * 891. 子序列宽度之和
 */
public class Day008SumSubsequenceWidths {
	public static void main(String[] args) {

	}

	public int sumSubseqWidths(int[] nums) {
		final int MOD = 1000000007;
		Arrays.sort(nums);
		long res = 0;
		long x = nums[0], y = 2;
		for (int j = 1; j < nums.length; j++) {
			res = (res + nums[j] * (y - 1) - x) % MOD;
			x = (x * 2 + nums[j]) % MOD;
			y = y * 2 % MOD;
		}
		return (int) ((res + MOD) % MOD);
	}
}
