package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/13 20:36 下午
 * 1234. 替换子串得到平衡字符串
 */
public class Day003_1234 {
	public int balancedString(String S) {
		var s = S.toCharArray();
		var cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
		for (var c : s) {
			++cnt[c];
		}
		int n = s.length, m = n / 4;
		if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
			return 0; // 已经符合要求啦
		}
		int ans = n, left = 0;
		for (int right = 0; right < n; right++) { // 枚举子串右端点
			--cnt[s[right]];
			while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
				ans = Math.min(ans, right - left + 1);
				++cnt[s[left++]]; // 缩小子串
			}
		}
		return ans;
	}
}
