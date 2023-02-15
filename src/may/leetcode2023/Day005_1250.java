package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/15 19:04 下午
 * 1250. 检查「好数组」
 */
public class Day005_1250 {
	/** 数学（裴蜀定理）
	 * @param nums
	 * @return
	 */
	public boolean isGoodArray(int[] nums) {
		int g = 0;
		for (int x : nums) {
			g = gcd(x, g);
		}
		return g == 1;
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
