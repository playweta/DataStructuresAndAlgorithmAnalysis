package may.leetcode;

/**
 * 1704. Determine if String Halves Are Alike
 *
 * @author liubr
 * @date 2022/11/11 13:05
 */
public class Day001DetermineIfStringHalvesAreAlike {
	public static void main(String[] args) {
		System.out.println(halvesAreAlike("textbook"));
	}
	/**
	 * 采用数组确定是否存在元音
	 *
	 * @param s
	 * @return
	 */
	public static boolean halvesAreAlike(String s) {
		int[] yy = new int[123];
		yy['a'] = yy['e'] = yy['i'] = yy['o'] = yy['u'] = yy['A'] = yy['E'] = yy['I'] = yy['O'] = yy['U'] = 1;
		int range = s.length() / 2, yc1 = 0, yc2 = 0;
		for (int i = 0; i < range; i++) {
			if (yy[s.charAt(i)] == 1) {
				yc1++;
			}
			if (yy[s.charAt(i + range)] == 1) {
				yc2++;
			}
		}
		return yc1 == yc2;
	}

	/**
	 * 采用字符串的indexOf确定是否存在元音
	 *
	 * @param s
	 * @return
	 */
	public static boolean halvesAreAlikeStr(String s) {
		String yy = "aeiouAEIOU";
		int range = s.length() / 2, yc1 = 0, yc2 = 0;
		for (int i = 0; i < range; i++) {
			if (yy.indexOf(s.charAt(i)) != -1) {
				yc1++;
			}
			if (yy.indexOf(s.charAt(i + range)) != -1) {
				yc2++;
			}
		}
		return yc1 == yc2;
	}
}

