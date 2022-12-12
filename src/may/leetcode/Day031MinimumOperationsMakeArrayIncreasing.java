package may.leetcode;

/**
 * @author liubr
 * @date 2022/12/11 14:22 下午
 * 1827. 最少操作使数组递增
 */
public class Day031MinimumOperationsMakeArrayIncreasing {
	public static void main(String[] args) {
		System.out.println(new Day031MinimumOperationsMakeArrayIncreasing().minOperations(new int[]{1, 1, 1}));
	}

	public int minOperations(int[] nums) {
		int count = 0;
		int len = nums.length;
		if (len <= 1) {
			return count;
		}
		for (int i = 1; i < len; i++) {
			if (nums[i - 1] >= nums[i]) {
				count += (nums[i - 1] - nums[i]) + 1;
				nums[i] += (nums[i - 1] - nums[i]) + 1;
			}
		}
		return count;
	}

	public int minOperationsGreedy(int[] nums) {
		int pre = nums[0] - 1, res = 0;
		for (int num : nums) {
			pre = Math.max(pre + 1, num);
			res += pre - num;
		}
		return res;
	}
}
