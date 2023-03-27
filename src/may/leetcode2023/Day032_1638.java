package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/27 19:39 下午
 * 1638. 统计只差一个字符的子串数目
 */
public class Day032_1638 {
	public int countSubstrings(String S, String T) {
		char[] s = S.toCharArray(), t = T.toCharArray();
		int ans = 0, n = s.length, m = t.length;
		for (int d = 1 - m; d < n; ++d) { // d=i-j, j=i-d
			int i = Math.max(d, 0);
			for (int k0 = i - 1, k1 = k0; i < n && i - d < m; ++i) {
				if (s[i] != t[i - d]) {
					k0 = k1; // 上上一个不同
					k1 = i;  // 上一个不同
				}
				ans += k1 - k0;
			}
		}
		return ans;
	}
}
