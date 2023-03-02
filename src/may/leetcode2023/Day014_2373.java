package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/02 19:44 下午
 */
public class Day014_2373 {
	public int[][] largestLocal(int[][] grid) {
		int n = grid.length;
		int[][] res = new int[n - 2][n - 2];
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				// 枚举每个3x3矩阵的起点，搜索局部的3x3矩阵最大值
				res[i][j] = localMax(grid, i, j);
			}
		}
		return res;
	}

	private int localMax(int[][] grid, int left, int top) {
		int max = 0;
		for (int i = left; i < left + 3; i++) {
			for (int j = top; j < top + 3; j++) {
				max = Math.max(max, grid[i][j]);
			}
		}
		return max;
	}
}
