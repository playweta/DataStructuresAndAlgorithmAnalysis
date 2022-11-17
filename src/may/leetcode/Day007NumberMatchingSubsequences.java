package may.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liubr
 * @date 2022/11/17 15:39
 * 792. 匹配子序列的单词数
 */
public class Day007NumberMatchingSubsequences {
	public static void main(String[] args) {
		System.out.println(new Day007NumberMatchingSubsequences().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
	}

	/**
	 * 分桶
	 * @param s
	 * @param words
	 * @return
	 */
	public int numMatchingSubseqBucket(String s, String[] words) {
		Deque<int[]>[] d = new Deque[26];
		for (int i = 0; i < 26; ++i) {
			d[i] = new ArrayDeque<>();
		}
		for (int i = 0; i < words.length; ++i) {
			d[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
		}
		int ans = 0;
		for (char c : s.toCharArray()) {
			var q = d[c - 'a'];
			for (int t = q.size(); t > 0; --t) {
				var p = q.pollFirst();
				int i = p[0], j = p[1] + 1;
				if (j == words[i].length()) {
					++ans;
				} else {
					d[words[i].charAt(j) - 'a'].offer(new int[]{i, j});
				}
			}
		}
		return ans;
	}

	/**
	 * 暴力超时
	 *
	 * @param s
	 * @param words
	 * @return
	 */
	public int numMatchingSubseq(String s, String[] words) {
		int count = 0;
		if (s.length() == 0 || words.length == 0) {
			return count;
		}
		for (String word : words) {
			int i = 0;
			for (char c : s.toCharArray()) {
				if (c == word.charAt(i)) {
					if (++i >= word.length()) {
						count++;
						break;
					}
				}
			}
		}
		return count;
	}
}
