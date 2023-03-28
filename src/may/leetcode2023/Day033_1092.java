package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/28 12:58 下午
 * 1092. 最短公共超序列
 */
public class Day033_1092 {
	public String shortestCommonSupersequence(String str1, String str2) {
		// f[i+1][j+1] 表示 s 的前 i 个字母和 t 的前 j 个字母的最短公共超序列的长度
		char[] s = str1.toCharArray(), t = str2.toCharArray();
		int n = s.length, m = t.length;
		var f = new int[n + 1][m + 1];
		// 递归边界
		for (int j = 1; j < m; ++j) {
			f[0][j] = j;
		}
		// 递归边界
		for (int i = 1; i < n; ++i) {
			f[i][0] = i;
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j)
			// 最短公共超序列一定包含 s[i]
			{
				if (s[i] == t[j]) {
					f[i + 1][j + 1] = f[i][j] + 1;
				} else // 取更短的组成答案
				{
					f[i + 1][j + 1] = Math.min(f[i][j + 1], f[i + 1][j]) + 1;
				}
			}
		}

		int na = f[n][m];
		var ans = new char[na];
		for (int i = n - 1, j = m - 1, k = na - 1; ; ) {
			// s 是空串，剩余的 t 就是最短公共超序列
			if (i < 0) {
				System.arraycopy(t, 0, ans, 0, j + 1);
				// 相当于递归边界
				break;
			}
			// t 是空串，剩余的 s 就是最短公共超序列
			if (j < 0) {
				System.arraycopy(s, 0, ans, 0, i + 1);
				// 相当于递归边界
				break;
			}
			// 公共超序列一定包含 s[i]
			if (s[i] == t[j]) {
				// 倒着填 ans
				ans[k--] = s[i--];
				--j; // 相当于继续递归 makeAns(i - 1, j - 1)
			} else if (f[i + 1][j + 1] == f[i][j + 1] + 1) {
				// 相当于继续递归 makeAns(i - 1, j)
				ans[k--] += s[i--];
			} else {
				// 相当于继续递归 makeAns(i, j - 1)
				ans[k--] += t[j--];
			}
		}
		return new String(ans);
	}
}
