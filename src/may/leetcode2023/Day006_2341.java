package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/16 16:29 下午
 * 2341. 数组能形成多少数对
 */
public class Day006_2341 {
	public int[] numberOfPairs(int[] nums) {
		int[] ints = new int[101];
		for (int num : nums) {
			ints[num]++;
		}
		int len = 0;
		for (int i : ints) {
			len += i / 2;
		}
		return new int[]{len, nums.length - len * 2};
	}
}
