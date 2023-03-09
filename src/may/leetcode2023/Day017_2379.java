package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/09 10:55 上午
 * 2379. 得到 K 个黑块的最少涂色次数
 */
public class Day017_2379 {
	public int minimumRecolors(String blocks, int k) {
		int cnt = 0;
		for (int i = 0; i < k; ++i) {
			cnt += blocks.charAt(i) == 'W' ? 1 : 0;
		}
		int ans = cnt;
		for (int i = k; i < blocks.length(); ++i) {
			cnt += blocks.charAt(i) == 'W' ? 1 : 0;
			cnt -= blocks.charAt(i - k) == 'W' ? 1 : 0;
			ans = Math.min(ans, cnt);
		}
		return ans;
	}
}
