package may.leetcode2023;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liubr
 * @date 2023/03/26 18:32 下午
 * 2395. 和相等的子数组
 */
public class Day031_2395 {
	public boolean findSubarrays(int[] nums) {
		Set<Integer> vis = new HashSet<>();
		for (int i = 1; i < nums.length; ++i) {
			if (!vis.add(nums[i - 1] + nums[i])) {
				return true;
			}
		}
		return false;
	}
}
