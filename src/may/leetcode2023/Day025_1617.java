package may.leetcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liubr
 * @date 2023/03/17 12:51 下午
 * 1617. 统计子树中城市之间最大距离
 */
public class Day025_1617 {
	private List<Integer>[] g;
	private int mask, vis, diameter;

	public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
		g = new ArrayList[n];
		Arrays.setAll(g, e -> new ArrayList<>());
		for (var e : edges) {
			// 编号改为从 0 开始
			int x = e[0] - 1, y = e[1] - 1;
			g[x].add(y);
			// 建树
			g[y].add(x);
		}

		var ans = new int[n - 1];
		// 二进制枚举
		for (mask = 3; mask < 1 << n; ++mask) {
			// 需要至少两个点
			if ((mask & (mask - 1)) == 0) {
				continue;
			}
			vis = diameter = 0;
			// 从一个在 mask 中的点开始递归
			dfs(Integer.numberOfTrailingZeros(mask));
			if (vis == mask) {
				++ans[diameter - 1];
			}
		}
		return ans;
	}

	// 求树的直径
	private int dfs(int x) {
		// 标记 x 访问过
		vis |= 1 << x;
		int maxLen = 0;
		for (int y : g[x]) {
			// y 没有访问过且在 mask 中
			if ((vis >> y & 1) == 0 && (mask >> y & 1) == 1) {
				int ml = dfs(y) + 1;
				diameter = Math.max(diameter, maxLen + ml);
				maxLen = Math.max(maxLen, ml);
			}
		}
		return maxLen;
	}
}
