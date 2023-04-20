package may.leetcode2023;

import java.util.Arrays;

/**
 * @author liubr
 * @date 2023/04/20 08:04 上午
 * 1187. 使数组严格递增
 */
public class Day047_1187 {
	public int makeArrayIncreasing(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		// 将arr2排序，方便进行二分查找
		Arrays.sort(arr2);
		// 由于结果数组严格递增，不可能存在相同元素，可以果断去重
		int n2 = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] != arr2[n2]) {
				arr2[++n2] = arr2[i];
			}
		}
		++n2;
		// 最大可能替换次数为 min(n1, n2) 即两个数组长度的最小值
		int max_step = Math.min(n1, n2);
		// 构造dp数组，dp[j]定义：对于子数组arr1，在使用不多于j次替换使得arr1前i个元素的子数组严格递增，前i个元素末尾元素所能达到的最小值
		// arr1 元素个数从0到n1，元素维度长度为 n1+1，替换次数为0到max_step，操作步数维度长度为 max_step+1
		int[] dp = new int[max_step + 1];
		int[] dp2 = new int[max_step + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// 由于 0 <= arr1[i], arr2[i] <= 10^9，最小元素值为0，构造边界-1，方便进行二分查找
		dp[0] = -1;
		// 用min_step记录使arr1前i个元素的子数组严格递增的最小操作步数，由于min_step随着i的增大一定单调非递减，所以可以单独提出来
		int min_step = 0;
		int prev = -1;
		// 二分查找左右指针
		int l = 0, r = n2 - 1; // [0, n2-1]
		for (int i = 1; i <= n1; ++i) {
			int curr_step = Integer.MAX_VALUE; // 用curr_step记录当前使arr1前i个元素的子数组严格递增的最小操作步数
			Arrays.fill(dp2, Integer.MAX_VALUE);
			for (int j = min_step; j <= Math.min(i, max_step); ++j) {
				// 不进行替换，如果arr1中的当前元素arr1[i-1]比之前i-1个元素构成序列最末尾元素大，直接添加到第i个元素位置
				if (dp[j] < arr1[i - 1]) {
					dp2[j] = arr1[i - 1];
				}
				// 如果可替换步数大于0，考虑用arr2中元素替换arr1中元素的情况
				if (j > 0) {
					// 如果当操作步数序列末尾元素比上一步序列末尾元素大，左指针继承，逐步缩小二分查找区间，否则进行重置
					if (dp[j - 1] > prev) {
						r = n2 - 1;
					} else {
						l = 0;
						r = n2 - 1;
					}
					prev = dp[j - 1]; // 前i-1个元素前j-1步操作后的末尾元素最小值
					// 二分查找arr2中比prev大且最接近prev的元素值
					while (l < r) {
						int mid = (l + r) >> 1;
						if (arr2[mid] <= prev) {
							l = mid + 1;
						} else {
							r = mid;
						}
					}
					if (arr2[l] > prev) { // 如果arr2中存在比prev大且最接近prev的元素值
						dp2[j] = Math.min(dp2[j], arr2[l]); // 取 min(dp[i][j], arr2[r])
					}
				}
				if (dp2[j] != Integer.MAX_VALUE) { // 如果可以经过最多j步操作使得arr1前i个元素的子数组严格递增
					curr_step = Math.min(curr_step, j); // 更新curr_step
				}
			}
			if (curr_step == Integer.MAX_VALUE) { // 如果不可以经过最多 min(i, max_step) 步操作使得arr1前i个元素的子数组严格递增
				return -1; // 如果无法让 arr1 严格递增，返回 -1。
			}
			min_step = curr_step; // 更新min_step
			for (int j = 0; j <= Math.min(i, max_step); ++j) {
				dp[j] = dp2[j];
			}
		}
		return min_step; // 返回使 arr1 严格递增所需要的最小操作步数
	}
}
