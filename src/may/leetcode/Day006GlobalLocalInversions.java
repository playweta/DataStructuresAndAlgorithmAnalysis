package may.leetcode;

/**
 * @author liubr
 * @date 2022/11/16 17:03
 */
public class Day006GlobalLocalInversions {

	public static void main(String[] args) {

	}

	public boolean isIdealPermutation(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (Math.abs(nums[i] - i) > 1) {
				return false;
			}
		}
		return true;
	}

}
