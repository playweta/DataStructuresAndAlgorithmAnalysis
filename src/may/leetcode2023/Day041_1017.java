package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/04/06 23:13 下午
 * 1017. 负二进制转换
 */
public class Day041_1017 {
	public String baseNeg2(int n) {
		if (n == 0) {
			return "0";
		}
		int k = 1;
		StringBuilder ans = new StringBuilder();
		while (n != 0) {
			if (n % 2 != 0) {
				ans.append(1);
				n -= k;
			} else {
				ans.append(0);
			}
			k *= -1;
			n /= 2;
		}
		return ans.reverse().toString();
	}
}
