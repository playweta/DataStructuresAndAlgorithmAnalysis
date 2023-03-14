package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/14 16:16 下午
 * 1605. 给定行和列的和求可行矩阵
 */
public class Day021_1605 {
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int m = rowSum.length, n = colSum.length;
		var mat = new int[m][n];
		for (int i = 0, j = 0; i < m && j < n; ) {
			int rs = rowSum[i], cs = colSum[j];
			if (rs < cs) { // 去掉第 i 行，往下走
				colSum[j] -= rs;
				mat[i++][j] = rs;
			} else { // 去掉第 j 列，往右走
				rowSum[i] -= cs;
				mat[i][j++] = cs;
			}
		}
		return mat;
	}
}
