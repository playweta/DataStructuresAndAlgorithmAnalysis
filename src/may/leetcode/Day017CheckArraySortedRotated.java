package may.leetcode;

/**
 * @author liubr
 * @date 2022/11/29 14:55
 * 1752. 检查数组是否经排序和轮转得到
 */
public class Day017CheckArraySortedRotated {

	public static void main(String[] args) {
		System.out.println(new Day017CheckArraySortedRotated().check(new int[]{3,4,5,1,2}));
	}

	public boolean check(int[] nums) {
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[(i + 1) % nums.length]) {
				cur++;
			}
		}
		return cur <= 1;
	}

}
