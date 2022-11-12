package may.dualmatch;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liubr
 * @date 2022/11/12 23:31
 * 第 91 场双周赛第一题
 * 6237. 不同的平均值数目
 */
public class Week_91_1NumberDistinctAverages {

	int cur = 0;
	Set<Double> arr = new HashSet<>();

	public static void main(String[] args) {
		System.out.println(new Week_91_1NumberDistinctAverages().distinctAverages(new int[]{1, 100}));
	}

	public int distinctAverages(int[] nums) {
		return sum(nums);
	}

	public int sum(int[] nums) {
		if (cur == nums.length) {
          return arr.size();
        }
		// 最大值
		int a = Integer.MIN_VALUE;
		// 最小值
		int b = Integer.MAX_VALUE;

		int x = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 100 && nums[i] > a) {
				a = nums[i];
				x = i;
			}
		}
		nums[x] = 101;
		cur++;
		int y = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 100 && nums[i] < b) {
				b = nums[i];
				y = i;
			}
		}
		nums[y] = 101;
		cur++;
		arr.add(((double) (a + b)) / 2.0);
		sum(nums);
		return arr.size();
	}
}
