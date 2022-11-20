package may.leetcode;

/**
 * @author liubr
 * @date 2022/11/20 11:18
 * 799. 香槟塔
 */
public class Day010ChampagneTower {

	/**
	 * 采用二维dp[][]计算
	 *
	 * @param poured
	 * @param query_row
	 * @param query_glass
	 * @return
	 */
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] dp = new double[query_row + 2][query_row + 2];
		// 为了方式越界，下标（0,0）的酒杯我们存放在dp[1][1]的位置上
		dp[1][1] = poured;
		for (int row = 2; row <= query_row + 1; row++) {
			for (int column = 1; column <= row; column++) {
				dp[row][column] = Math.max(dp[row - 1][column - 1] - 1, 0) / 2 + Math.max(dp[row - 1][column] - 1, 0) / 2;
			}
		}
		return Math.min(dp[query_row + 1][query_glass + 1], 1);
	}

	/**
	 * 采用一维dp[]计算
	 *
	 * @param poured
	 * @param query_row
	 * @param query_glass
	 * @return
	 */
	public double champagneTowerOne(int poured, int query_row, int query_glass) {
		// 第i层中每个glass的容量
		double[] dp = new double[query_glass + 2];
		// 第0层的第0个编号酒杯倾倒香槟容量
		dp[0] = poured;
		int row = 0;
		// 获取第query_row行，只需要遍历到第query_row减1行即可。
		while (row < query_row) {
			for (int glass = Math.min(row, query_glass); glass >= 0; glass--) {
				double overflow = Math.max(dp[glass] - 1, 0) / 2.0;
				// 覆盖掉旧值
				dp[glass] = overflow;
				// 由于是倒序遍历，所以对于dp[glass + 1]要执行“+=”操作
				dp[glass + 1] += overflow;
			}
			row++; // 计算下一行
		}
		// 如果倾倒香槟容量大于1，则只返回1.
		return Math.min(dp[query_glass], 1);
	}
}
