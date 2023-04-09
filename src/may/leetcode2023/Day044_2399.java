package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/04/09 15:27 下午
 * 2399. 检查相同字母间的距离
 */
public class Day044_2399 {
	public boolean checkDistances(String s, int[] distance) {
		int[] d = new int[26];
		for (int i = 1, n = s.length(); i <= n; ++i) {
			int j = s.charAt(i - 1) - 'a';
			if (d[j] > 0 && i - d[j] - 1 != distance[j]) {
				return false;
			}
			d[j] = i;
		}
		return true;
	}
}
