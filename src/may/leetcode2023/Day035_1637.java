package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/30 12:38 下午
 * 1637. 两点之间不包含任何点的最宽垂直区域
 */
public class Day035_1637 {
	public int maxWidthOfVerticalArea(int[][] points) {
		int n = points.length;
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i) {
			nums[i] = points[i][0];
		}
		final int inf = 1 << 30;
		int mi = inf, mx = -inf;
		for (int v : nums) {
			mi = Math.min(mi, v);
			mx = Math.max(mx, v);
		}
		int bucketSize = Math.max(1, (mx - mi) / (n - 1));
		int bucketCount = (mx - mi) / bucketSize + 1;
		int[][] buckets = new int[bucketCount][2];
		for (var bucket : buckets) {
			bucket[0] = inf;
			bucket[1] = -inf;
		}
		for (int v : nums) {
			int i = (v - mi) / bucketSize;
			buckets[i][0] = Math.min(buckets[i][0], v);
			buckets[i][1] = Math.max(buckets[i][1], v);
		}
		int prev = inf;
		int ans = 0;
		for (var bucket : buckets) {
			if (bucket[0] > bucket[1]) {
				continue;
			}
			ans = Math.max(ans, bucket[0] - prev);
			prev = bucket[1];
		}
		return ans;
	}
}
