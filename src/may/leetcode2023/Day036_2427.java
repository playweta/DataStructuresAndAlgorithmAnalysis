package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/04/05 23:18 下午
 * 2427. 公因子的数目
 */
public class Day036_2427 {
	public int commonFactors(int a, int b) {
		int cnt = 0;
		for (int i = 1; i <= Math.min(a, b); i++) {
			cnt += a % i == 0 && b % i == 0 ? 1 : 0;
		}
		return cnt;
	}
}
