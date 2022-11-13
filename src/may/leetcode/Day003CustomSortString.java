package may.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 791. 自定义字符串排序
 *
 * @author liubr
 * @date 2022/11/13 10:21
 * <p>
 * # 计数器排序  # 自定义排序
 */
public class Day003CustomSortString {
	public static void main(String[] args) {
		System.out.println(new Day003CustomSortString().customSortString("cba", "abcd"));
	}

	/**
	 * 计数器排序
	 *
	 * @param order
	 * @param s
	 * @return
	 */
	public String customSortString(String order, String s) {
		int[] cur = new int[26];
		for (char c : s.toCharArray()) {
			++cur[c - 'a'];
		}
		StringBuilder sb = new StringBuilder();
		for (char c : order.toCharArray()) {
			while (cur[c - 'a']-- > 0) {
				sb.append(c);
			}
		}
		for (int i = 0; i < 26; i++) {
			while (cur[i]-- > 0) {
				sb.append((char) (i + 'a'));
			}
		}
		return sb.toString();
	}

	/**
	 * 自定义排序
	 *
	 * @param order
	 * @param s
	 * @return
	 */
	public String customSortStringDev(String order, String s) {
		int[] d = new int[26];
		for (int i = 0; i < order.length(); ++i) {
			d[order.charAt(i) - 'a'] = i;
		}
		List<Character> cs = new ArrayList<>();
		for (int i = 0; i < s.length(); ++i) {
			cs.add(s.charAt(i));
		}
		cs.sort(Comparator.comparingInt(a -> d[a - 'a']));
		return cs.stream().map(String::valueOf).collect(Collectors.joining());
	}
}
