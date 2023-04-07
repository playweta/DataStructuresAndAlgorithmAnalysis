package may.leetcode2023;

import java.util.Arrays;

/**
 * @author liubr
 * @date 2023/04/07 11:15 上午
 * 1040. 移动石子直到连续 II
 */
public class Day042_1040 {
	public int[] numMovesStonesII(int[] s) {
		Arrays.sort(s);
		int n = s.length;
		int e1 = s[n - 2] - s[0] - n + 2;
		int e2 = s[n - 1] - s[1] - n + 2; // 计算空位
		int maxMove = Math.max(e1, e2);
		if (e1 == 0 || e2 == 0) // 特殊情况：没有空位
			return new int[]{Math.min(2, maxMove), maxMove};
		int maxCnt = 0, left = 0;
		for (int right = 0; right < n; ++right) { // 滑动窗口：枚举右端点
			while (s[right] - s[left] + 1 > n) // 窗口大小大于 n
				++left;
			maxCnt = Math.max(maxCnt, right - left + 1); // 维护窗口内的最大石子数
		}
		return new int[]{n - maxCnt, maxMove};
	}
}
