package may.leetcode2023;

import java.util.HashMap;

/**
 * @author liubr
 * @date 2023/03/10 11:37 上午
 * 1590. 使数组和能被 P 整除
 */
public class Day018_1590 {
	public int minSubarray(int[] nums, int p) {
		int n = nums.length, ans = n;
		var s = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			s[i + 1] = (s[i] + nums[i]) % p;
		}
		int x = s[n];
		// 移除空子数组（这行可以不要）
		if (x == 0) {
			return 0;
		}

		var last = new HashMap<Integer, Integer>();
		for (int i = 0; i <= n; ++i) {
			last.put(s[i], i);
			// 如果不存在，-n 可以保证 i-j >= n
			int j = last.getOrDefault((s[i] - x + p) % p, -n);
			ans = Math.min(ans, i - j);
		}
		return ans < n ? ans : -1;
	}
}
