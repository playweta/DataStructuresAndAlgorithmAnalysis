package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/21 08:31 上午
 * 1326. 灌溉花园的最少水龙头数目
 */
public class Day010_1326 {
	public int minTaps(int n, int[] ranges) {
		int[] land = new int[n];
		for (int i = 0; i < ranges.length; i++) {
			int l = Math.max(i - ranges[i], 0);
			int r = Math.min(i + ranges[i], n);
			for (int j = l; j < r; j++) {
				land[j] = Math.max(land[j], r);
			}
		}

		int cnt = 0;
		int cur = 0;
		while (cur < n) {
			if (land[cur] == 0) {
				return -1;
			}
			cur = land[cur];
			cnt++;
		}
		return cnt;
	}
}
