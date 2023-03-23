package may.leetcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liubr
 * @date 2023/03/23 21:39 下午
 * 1630. 等差子数组
 */
public class Day029_1630 {
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		int m = l.length;
		List<Boolean> res = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int left = l[i];
			int right = r[i];
			int[] temp = new int[right - left + 1];
			int index = 0;
			for (int j = left; j <= right; j++) {
				temp[index++] = nums[j];
			}
			Arrays.sort(temp);
			boolean flag = true;
			for (int j = 2; j < temp.length; j++) {
				if (temp[j] - temp[j - 1] != temp[1] - temp[0]) {
					flag = false;
					break;
				}
			}
			res.add(flag);
		}
		return res;
	}
}
