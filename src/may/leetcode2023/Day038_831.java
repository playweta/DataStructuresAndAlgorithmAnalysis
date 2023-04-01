package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/04/01 11:01 上午
 * 831. 隐藏个人信息
 */
public class Day038_831 {
	public static void main(String[] args) {

	}

	public String maskPII(String s) {
		int a = s.indexOf("@");
		if (a >= 0) {
			return (s.charAt(0) + "*****" + s.substring(a - 1)).toLowerCase();
		} else {
			String digits = s.replaceAll("\\D+", "");
			String local = "***-***-" + digits.substring(digits.length() - 4);
			if (digits.length() == 10) {
				return local;
			}
			return "+" + "*".repeat(Math.max(0, digits.length() - 10)) + "-" + local;
		}
	}
}
