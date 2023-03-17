package may.leetcode2023;

import java.util.Arrays;

/**
 * @author liubr
 * @date 2023/03/17 12:46 下午
 * 2389. 和有限的最长子序列
 */
public class Day024_2389 {
	public int[] answerQueries(int[] nums, int[] queries) {
		long[] sum = new long[10010];
		int[] res = new int[queries.length];
		//排序改变位置不影响结果
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		for (int i = 0; i < queries.length; i++) {
			int l = 0, r = nums.length;
			//二分查找
			while (l < r) {
				int mid = l + r + 1 >> 1;
				//直接查找sum即可
				if (sum[mid] <= queries[i]) {
					l = mid;
				} else {
					r = mid - 1;
				}
			}
			res[i] = r;
		}
		return res;
	}
}
