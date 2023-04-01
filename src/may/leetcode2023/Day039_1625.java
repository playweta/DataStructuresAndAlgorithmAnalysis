package may.leetcode2023;

import java.util.*;

/**
 * @author liubr
 * @date 2023/04/01 11:22 上午
 * 1625. 执行操作后字典序最小的字符串
 */
public class Day039_1625 {
	public String findLexSmallestString(String s, int a, int b) {
		Deque<String> q = new ArrayDeque<>();
		q.offer(s);
		Set<String> vis = new HashSet<>();
		vis.add(s);
		String ans = s;
		int n = s.length();
		while (!q.isEmpty()) {
			s = q.poll();
			if (ans.compareTo(s) > 0) {
				ans = s;
			}
			char[] cs = s.toCharArray();
			for (int i = 1; i < n; i += 2) {
				cs[i] = (char) (((cs[i] - '0' + a) % 10) + '0');
			}
			String t1 = String.valueOf(cs);
			String t2 = s.substring(n - b) + s.substring(0, n - b);
			for (String t : List.of(t1, t2)) {
				if (vis.add(t)) {
					q.offer(t);
				}
			}
		}
		return ans;
	}
}
