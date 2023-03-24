package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/24 13:13 下午
 * 1032. 字符流
 */
public class Day030_1032 {

}

class Trie {
	Trie[] children = new Trie[26];
	boolean isEnd = false;

	public void insert(String w) {
		Trie node = this;
		for (int i = w.length() - 1; i >= 0; --i) {
			int idx = w.charAt(i) - 'a';
			if (node.children[idx] == null) {
				node.children[idx] = new Trie();
			}
			node = node.children[idx];
		}
		node.isEnd = true;
	}

	public boolean query(StringBuilder s) {
		Trie node = this;
		for (int i = s.length() - 1, j = 0; i >= 0 && j < 201; --i, ++j) {
			int idx = s.charAt(i) - 'a';
			if (node.children[idx] == null) {
				return false;
			}
			node = node.children[idx];
			if (node.isEnd) {
				return true;
			}
		}
		return false;
	}
}

class StreamChecker {
	private final StringBuilder sb = new StringBuilder();
	private final Trie trie = new Trie();

	public StreamChecker(String[] words) {
		for (String w : words) {
			trie.insert(w);
		}
	}

	public boolean query(char letter) {
		sb.append(letter);
		return trie.query(sb);
	}
}
