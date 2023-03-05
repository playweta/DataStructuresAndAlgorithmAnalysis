package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/05 20:33 下午
 * 1599. 经营摩天轮的最大利润
 */
public class Day016_1599 {
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
		int ans = -1;
		int mx = 0, t = 0;
		int wait = 0, i = 0;
		while (wait > 0 || i < customers.length) {
			wait += i < customers.length ? customers[i] : 0;
			int up = Math.min(4, wait);
			wait -= up;
			++i;
			t += up * boardingCost - runningCost;
			if (t > mx) {
				mx = t;
				ans = i;
			}
		}
		return ans;
	}
}
