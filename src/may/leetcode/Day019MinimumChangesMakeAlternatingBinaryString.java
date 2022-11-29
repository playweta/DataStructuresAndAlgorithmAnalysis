package may.leetcode;

/**
 * @author liubr
 * @date 2022/11/29 15:14
 * 1758. 生成交替二进制字符串的最少操作数
 */
public class Day019MinimumChangesMakeAlternatingBinaryString {
	public static void main(String[] args) {
		System.out.println(new Day019MinimumChangesMakeAlternatingBinaryString().minOperations("1001"));
	}

	public int minOperations(String s) {
		int cur = 0, n = s.length();
		for (int i = 0; i < n; i++) {
			cur += (s.charAt(i) - '0') ^ (i & 1);
		}
		return Math.min(cur, n - cur);
	}
}
