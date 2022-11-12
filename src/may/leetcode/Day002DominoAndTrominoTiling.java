package may.leetcode;

/**
 * 790. 多米诺和托米诺平铺
 *
 * @author liubr
 * @date 2022/11/12 11:56
 */
public class Day002DominoAndTrominoTiling {

	private static final long MOD = (long) 1e9 + 7;

	public static void main(String[] args) {
		System.out.println(numTilings(3));
	}

	public static int numTilings(int n) {
		if (n == 1) {
			return 1;
		}
		long a = 1, b = 1, c = 2;
		for (int i = 3; i <= n; ++i) {
			long f = (c * 2 + a) % MOD;
			a = b;
			b = c;
			c = f;
		}
		return (int) c;
	}


	//----------------------------------------

	private static final long[] F = new long[1001];

	static {
		F[0] = F[1] = 1;
		F[2] = 2;
		for (int i = 3; i <= 1000; ++i) {
			F[i] = (F[i - 1] * 2 + F[i - 3]) % MOD;
		}
	}

	public int numTilingsStat(int n) {
		return (int) F[n];
	}
}
