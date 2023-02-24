package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/24 21:23 下午
 * 2357. 使数组中所有元素都等于零
 */
public class Day011_2357 {
	public int minimumOperations(int[] nums) {
		boolean[] s = new boolean[101];
		s[0] = true;
		int ans = 0;
		for (int x : nums) {
			if (!s[x]) {
				++ans;
				s[x] = true;
			}
		}
		return ans;
	}
}
