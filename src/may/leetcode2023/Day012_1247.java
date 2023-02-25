package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/25 21:29 下午
 * 1247. 交换字符使得字符串相同
 */
public class Day012_1247 {
	public int minimumSwap(String s1, String s2) {
		int[] cnt = new int[2];
		for (int i = 0, n = s1.length(); i < n; ++i) {
			if (s1.charAt(i) != s2.charAt(i)) {
				// x 和 y ASCII 值的二进制最低位不同
				++cnt[s1.charAt(i) % 2];
			}
		}
		int d = cnt[0] + cnt[1];
		return d % 2 != 0 ? -1 : d / 2 + cnt[0] % 2;
	}
}
