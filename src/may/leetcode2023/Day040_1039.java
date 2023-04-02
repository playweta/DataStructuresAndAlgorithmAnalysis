package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/04/02 09:14 上午
 * 1039. 多边形三角剖分的最低得分
 */
public class Day040_1039 {
	public static void main(String[] args) {

	}

	public int minScoreTriangulation(int[] v) {
		int n = v.length;
		int[][] f = new int[n][n];
		for (int i = n - 3; i >= 0; --i)
			for (int j = i + 2; j < n; ++j) {
				f[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; ++k)
					f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + v[i] * v[j] * v[k]);
			}
		return f[0][n - 1];
	}
}
