package may.leetcode;

/**
 * @author liubr
 * @date 2022/12/04 16:51
 * 1774. 最接近目标价格的甜点成本
 */
public class Day024ClosestDessertCost {
	int ans = 0x3f3f3f3f;

	public int closestCost(int[] base, int[] top, int target) {
		for (int x : base) dfs(0, x, target, top);
		return ans;
	}

	void dfs(int x, int sum, int target, int[] top) {
		int a = Math.abs(target - sum), b = Math.abs(target - ans);
		if (a < b) ans = sum;
		if (a == b && sum < ans) ans = sum;
		if (sum > target) return;
		for (int i = x; i < top.length; i++) {
			dfs(i + 1, sum + top[i], target, top);
			dfs(i + 1, sum + 2 * top[i], target, top);
		}
	}
}
