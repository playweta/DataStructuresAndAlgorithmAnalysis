package may.leetcode2023;

import java.util.HashMap;

/**
 * @author liubr
 * @date 2023/03/16 13:42 下午
 * 2488. 统计中位数为 K 的子数组
 */
public class Day023_2488 {
	public int countSubarrays(int[] nums, int k) {
		int pos = 0, n = nums.length;
		while (nums[pos] != k) {
			++pos;
		}
		var cnt = new HashMap<Integer, Integer>();
		// i=pos 的时候 x 是 0，直接记到 cnt 中，这样下面不是大于 k 就是小于 k
		cnt.put(0, 1);
		// 从 pos-1 开始累加 x
		for (int i = pos - 1, x = 0; i >= 0; --i) {
			x += nums[i] < k ? 1 : -1;
			cnt.merge(x, 1, Integer::sum);
		}

		// i=pos 的时候 x 是 0，直接加到答案中，这样下面不是大于 k 就是小于 k
		int ans = cnt.get(0) + cnt.getOrDefault(-1, 0);
		// 从 pos+1 开始累加 x
		for (int i = pos + 1, x = 0; i < n; ++i) {
			x += nums[i] > k ? 1 : -1;
			ans += cnt.getOrDefault(x, 0) + cnt.getOrDefault(x - 1, 0);
		}
		return ans;
	}
}
