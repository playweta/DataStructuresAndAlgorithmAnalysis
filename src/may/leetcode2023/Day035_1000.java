package may.leetcode2023;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author liubr
 * @date 2023/04/04 10:51 上午
 * 1000. 合并石头的最低成本
 */
public class Day035_1000 {

	public int mergeStones(int[] stones, int K) {
		int n = stones.length;
		if ((n - 1) % (K - 1) != 0) {
			return -1;
		}

		int[] prefixSum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
		}

		int[][][] memo = new int[n][n][K + 1];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}

		int ans = dfs(stones, K, prefixSum, 0, n - 1, 1, memo);
		return ans;
	}

	private int dfs(int[] stones, int K, int[] prefixSum, int i, int j, int k, int[][][] memo) {
		if (i == j) {
			return k == 1 ? 0 : -1;
		}
		if (k == 1) {
			int cost = dfs(stones, K, prefixSum, i, j, K, memo);
			if (cost == -1) {
				return -1;
			}
			return cost + prefixSum[j + 1] - prefixSum[i];
		}
		if (memo[i][j][k] != -1) {
			return memo[i][j][k];
		}

		int cost = Integer.MAX_VALUE;
		for (int p = i; p < j; p += K - 1) {
			int leftCost = dfs(stones, K, prefixSum, i, p, 1, memo);
			int rightCost = dfs(stones, K, prefixSum, p + 1, j, k - 1, memo);
			if (leftCost == -1 || rightCost == -1) {
				continue;
			}
			cost = Math.min(cost, leftCost + rightCost);
		}
		memo[i][j][k] = cost == Integer.MAX_VALUE ? -1 : cost;
		return memo[i][j][k];
	}
}


