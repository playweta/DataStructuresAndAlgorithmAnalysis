package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/02 19:39 下午
 */
public class Day013_面试题0502 {
	public String printBin(double num) {
		var bin = new StringBuilder("0.");
		// 至多循环 6 次
		for (int i = 0; i < 6; ++i) {
			num *= 2;
			if (num < 1) {
				bin.append('0');
			} else {
				bin.append('1');
				if (--num == 0) {
					return bin.toString();
				}
			}
		}
		return "ERROR";
	}
}
