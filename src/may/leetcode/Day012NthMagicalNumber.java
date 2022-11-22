package may.leetcode;

/**
 * @author liubr
 * @date 2022/11/22 21:59
 * 878. 第 N 个神奇数字
 */
public class Day012NthMagicalNumber {
	private static final long MOD = (long) 1e9 + 7;
	int n, a, b, c;

	public int nthMagicalNumber(int n, int a, int b) {
		long lcm = (long) a / gcd(a, b) * b;
		// 开区间 (left, right)
		long left = 0, right = (long) Math.max(a, b) * n;
		// 开区间不为空
		while (left + 1 < right) {
			long mid = left + (right - left) / 2;
			if (mid / a + mid / b - mid / lcm >= n) {
				// 范围缩小到 (left, mid)
				right = mid;
			} else {
				// 范围缩小到 (mid, right)
				left = mid;
			}
		}
		return (int) (right % MOD);
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public int nthMagicalNumberS(int _n, int _a, int _b) {
		n = _n;
		a = _a;
		b = _b;
		c = a * b / gcd(a, b);
		long l = 0, r = (long) 1e18;
		while (l < r) {
			long mid = l + r >> 1;
			if (check(mid) >= n) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return (int) (r % 1000000007);
	}

	long check(long x) {
		return x / a + x / b - x / c;
	}

}
