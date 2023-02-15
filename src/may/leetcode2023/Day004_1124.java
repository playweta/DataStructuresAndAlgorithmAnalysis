package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/15 19:01 下午
 * 1124. 表现良好的最长时间段
 */
public class Day004_1124 {
	public int longestWPI(int[] hours) {
		int n = hours.length, ans = 0, s = 0;
		// 记录前缀和首次出现的位置
		var pos = new int[n + 2];
		for (int i = 1; i <= n; ++i) {
			// 取反，改为减法
			s -= hours[i - 1] > 8 ? 1 : -1;
			if (s < 0) {
				ans = i;
			} else {
				if (pos[s + 1] > 0) {
					ans = Math.max(ans, i - pos[s + 1]);
				}
				if (pos[s] == 0) {
					pos[s] = i;
				}
			}
		}
		return ans;
	}
}
