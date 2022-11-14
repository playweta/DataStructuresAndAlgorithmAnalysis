package may.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liubr
 * @date 2022/11/14 10:50
 *
 * 805. 数组的均值分割
 * # 折半搜索 + 二进制枚举 + 哈希表 + 数学
 */
public class Day004SplitArrayWithSameAverage {
	public static void main(String[] args) {

	}

	/**
	 * 折半搜索 + 二进制枚举 + 哈希表 + 数学
	 * @param nums
	 * @return
	 */
	public boolean splitArraySameAverage(int[] nums) {
		int n = nums.length, m = n / 2, sum = 0;
		for (int x : nums) sum += x;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int s = 0; s < (1 << m); s++) {
			int tot = 0, cnt = 0;
			for (int i = 0; i < m; i++) {
				if (((s >> i) & 1) == 1) {
					tot += nums[i];
					cnt++;
				}
			}
			Set<Integer> set = map.getOrDefault(tot, new HashSet<>());
			set.add(cnt);
			map.put(tot, set);
		}
		for (int s = 0; s < (1 << (n - m)); s++) {
			int tot = 0, cnt = 0;
			for (int i = 0; i < (n - m); i++) {
				if (((s >> i) & 1) == 1) {
					tot += nums[i + m];
					cnt++;
				}
			}
			for (int k = Math.max(1, cnt); k < n; k++) {
				if (k * sum % n != 0) continue;
				int t = k * sum / n;
				if (!map.containsKey(t - tot)) continue;
				if (!map.get(t - tot).contains(k - cnt)) continue;
				return true;
			}
		}
		return false;
	}
}
