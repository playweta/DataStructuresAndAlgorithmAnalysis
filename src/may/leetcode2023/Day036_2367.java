package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/31 12:20 下午
 * 2367. 算术三元组的数目
 */
public class Day036_2367 {
	public static void main(String[] args) {
		System.out.println(new Day036_2367().arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
	}

	public int arithmeticTriplets(int[] nums, int diff) {
		int dis = 0;
		int i;
		int j;
		int k;
		for (k = 2; k < nums.length; k++) {
			for (j = 1; j < k; j++) {
				for (i = 0; i < j; i++) {
					if (nums[j] - nums[i] == nums[k] - nums[j] && nums[k] - nums[j] == diff) {
						dis++;
					}
				}
			}
		}
		return dis;
	}
	public int arithmeticTripletsTow(int[] nums, int diff) {
		boolean[] vis = new boolean[301];
		for (int x : nums) {
			vis[x] = true;
		}
		int ans = 0;
		for (int x : nums) {
			if (vis[x + diff] && vis[x + diff + diff]) {
				++ans;
			}
		}
		return ans;
	}
}
