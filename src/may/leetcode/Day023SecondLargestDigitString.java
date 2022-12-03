package may.leetcode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liubr
 * @date 2022/12/03 12:56
 * 1796. 字符串中第二大的数字
 */
public class Day023SecondLargestDigitString {
	public static void main(String[] args) {
		System.out.println(new Day023SecondLargestDigitString().secondHighest("ck077"));
	}

	public int secondHighest(String s) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				set.add(Integer.parseInt(String.valueOf(s.charAt(i))));
			}
		}
		List<Integer> list = set.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		return list.size() >= 2 ? list.get(list.size() - 2) : -1;
	}

	public int secondHighestWei(String s) {
		int mask = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				mask |= 1 << (c - '0');
			}
		}
		for (int i = 9, cnt = 0; i >= 0; --i) {
			if (((mask >> i) & 1) == 1 && ++cnt == 2) {
				return i;
			}
		}
		return -1;
	}
}
