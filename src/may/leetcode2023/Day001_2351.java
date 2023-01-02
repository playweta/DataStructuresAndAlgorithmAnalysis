package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/01/01 16:21 下午
 * 2351. 第一个出现两次的字母
 */
public class Day001_2351 {
	public static void main(String[] args) {

	}

	public char repeatedCharacter(String s) {
		int[] ints = new int[26];
		int i = 0;
		while (true) {
			char charA = s.charAt(i);
			if (++ints[charA - 'a'] == 2) {
				return charA;
			}
			++i;
		}
	}
	public char repeatedCharacterWei(String s) {
		int mask = 0;
		for (int i = 0; ; ++i) {
			char c = s.charAt(i);
			if ((mask >> (c - 'a') & 1) == 1) {
				return c;
			}
			mask |= 1 << (c - 'a');
		}
	}

}
