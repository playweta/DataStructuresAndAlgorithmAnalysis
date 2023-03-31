package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/31 12:51 下午
 * 1574. 删除最短的子数组使剩余数组有序
 */
public class Day037_1574 {
	public static void main(String[] args) {
		System.out.println(new Day037_1574().findLengthOfShortestSubarray(new int[]{2, 2, 2, 1, 1, 1}));
	}

	public int findLengthOfShortestSubarray(int[] arr) {
		int n = arr.length, right = n - 1;
		while (right > 0 && arr[right - 1] <= arr[right]) {
			--right;
		}
		if (right == 0) {
			// arr 已经是非递减数组
			return 0;
		}
		// 此时 arr[right-1] > arr[right]
		// 删除 0 到 right-1
		int ans = right;
		// 枚举 right
		for (int left = 0; ; ++right) {
			while (right == n || arr[left] <= arr[right]) {
				// 中间 left+1 到 right-1 可以删除
				ans = Math.min(ans, right - left - 1);
				if (arr[left] > arr[left + 1]) {
					return ans;
				}
				++left;
			}
		}

	}
}
