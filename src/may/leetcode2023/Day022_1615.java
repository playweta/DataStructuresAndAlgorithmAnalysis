package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/15 18:31 下午
 * 1615. 最大网络秩
 */
public class Day022_1615 {
	public int maximalNetworkRank(int n, int[][] roads) {
		int[][] g = new int[n][n];
		int[] cnt = new int[n];
		for (var r : roads) {
			int a = r[0], b = r[1];
			g[a][b] = 1;
			g[b][a] = 1;
			++cnt[a];
			++cnt[b];
		}
		int ans = 0;
		for (int a = 0; a < n; ++a) {
			for (int b = a + 1; b < n; ++b) {
				ans = Math.max(ans, cnt[a] + cnt[b] - g[a][b]);
			}
		}
		return ans;
	}
}
