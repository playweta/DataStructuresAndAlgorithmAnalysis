package may.leetcode;

/**
 * @author liubr
 * @date 2022/12/11 15:24 下午
 * 1780. 判断一个数字是否可以表示成三的幂的和
 */
public class Day029CheckNumberSumPowersThree {
	public static void main(String[] args) {
	}
	public boolean checkPowersOfThree(int n) {
		while (n != 0) {
			if (n % 3 == 2) {
				return false;
			}
			n /= 3;
		}
		return true;
	}
}
