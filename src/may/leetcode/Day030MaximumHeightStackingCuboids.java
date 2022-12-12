package may.leetcode;

import java.util.Arrays;

/**
 * @author liubr
 * @date 2022/12/12 15:34 下午
 * 1691. 堆叠长方体的最大高度
 */
public class Day030MaximumHeightStackingCuboids {
	public int maxHeight(int[][] cuboids) {
		for (int[] c : cuboids)
			Arrays.sort(c);
		Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
		int ans = 0, n = cuboids.length;
		int[] f = new int[n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j)
				// 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
				if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2])
					// cuboids[j] 可以堆在 cuboids[i] 上
					f[i] = Math.max(f[i], f[j]);
			f[i] += cuboids[i][2];
			ans = Math.max(ans, f[i]);
		}
		return ans;
	}
}
