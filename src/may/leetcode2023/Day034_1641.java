package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/29 09:47 上午
 * 1641. 统计字典序元音字符串的数目
 */
public class Day034_1641 {
	private Integer[][] f;
	private int n;

	public int countVowelStrings(int n) {
		this.n = n;
		f = new Integer[n][5];
		return dfs(0, 0);
	}

	private int dfs(int i, int j) {
		if (i >= n) {
			return 1;
		}
		if (f[i][j] != null) {
			return f[i][j];
		}
		int ans = 0;
		for (int k = j; k < 5; ++k) {
			ans += dfs(i + 1, k);
		}
		return f[i][j] = ans;
	}
}
