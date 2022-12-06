package may.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liubr
 * @date 2022/12/06 14:13
 * 1805. 字符串中不同整数的数目
 */
public class Day026NumberDifferentIntegersString {

	public static void main(String[] args) {
		System.out.println(new Day026NumberDifferentIntegersString().numDifferentIntegers("035985750011523523129774573439111590559325a1554234973"));
	}

	public int numDifferentIntegers(String word) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) <= '9') {
				int j = i;
				while (j < word.length() && word.charAt(j) <= '9') j++;
				while (i < j && word.charAt(i) == '0') i++;
				set.add(word.substring(i, j));
				i = j;
			}
		}
		return set.size();
	}
}
