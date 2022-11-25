package may.leetcode;

/**
 * @author liubr
 * @date 2022/11/25 16:59
 * 809. 情感丰富的文字
 */
public class Day015ExpressiveWords {

	public static void main(String[] args) {

	}

	public int expressiveWords(String s, String[] words) {
		int result = 0;
		char[] sc = s.toCharArray();
		for (String word : words) {
			result += stretchyWord(sc, word.toCharArray()) ? 1 : 0;
		}
		return result;
	}

	private boolean stretchyWord(char[] sc, char[] wc) {
		// word的字符串长度不允许超过s的字符串长度
		if (sc.length < wc.length) {
			return false;
		}
		int cp, p1 = 0, p2 = p1;
		while ((cp = p1) < sc.length && p2 < wc.length) {
			int c1 = 0, c2 = 0;
			while (p1 < sc.length && sc[p1] == sc[cp]) {
				c1++;
				p1++; // 在字符串s中，遍历连续的字符sc[cp]的数量
			}
			while (p2 < wc.length && wc[p2] == sc[cp]) {
				c2++;
				p2++; // 在字符串word中，遍历连续的的字符sc[cp]的数量
			}
			if ((c1 != c2 && c1 < 3) || (c1 < c2 && c1 >= 3)) {
				return false;
			}
		}
		// 只有sc和wc都被遍历完毕，才返回true
		return p1 == sc.length && p2 == wc.length;
	}
}
