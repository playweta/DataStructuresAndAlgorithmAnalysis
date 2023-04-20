package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/04/21 07:31 上午
 * 2413. 最小偶倍数
 */
public class Day048_2413 {
	public static void main(String[] args) {

	}

	public int smallestEvenMultiple(int n) {
		return n << (n & 1);
	}
}
