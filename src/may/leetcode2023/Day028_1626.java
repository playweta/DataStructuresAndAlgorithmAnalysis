package may.leetcode2023;

import java.util.Arrays;

/**
 * @author liubr
 * @date 2023/03/22 13:03 下午
 * 1626. 无矛盾的最佳球队
 */
public class Day028_1626 {
	public int bestTeamScore(int[] scores, int[] ages) {
		int n = ages.length;
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; ++i) {
			arr[i] = new int[]{scores[i], ages[i]};
		}
		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int[] f = new int[n];
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i][1] >= arr[j][1]) {
					f[i] = Math.max(f[i], f[j]);
				}
			}
			f[i] += arr[i][0];
			ans = Math.max(ans, f[i]);
		}
		return ans;
	}
}
