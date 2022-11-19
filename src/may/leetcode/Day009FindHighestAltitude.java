package may.leetcode;

/**
 * @author liubr
 * @date 2022/11/19 11:27
 * 1732. 找到最高海拔
 */
public class Day009FindHighestAltitude {
	public static void main(String[] args) {
		System.out.println(new Day009FindHighestAltitude().largestAltitude(new int[]{-5, 1, 5, 0, -7}));
	}

	public int largestAltitude(int[] gain) {
		int a = 0;
		int count = 0;
		for (int i : gain) {
			count += i;
			a = Math.max(a, count);
		}
		return a;
	}
}
