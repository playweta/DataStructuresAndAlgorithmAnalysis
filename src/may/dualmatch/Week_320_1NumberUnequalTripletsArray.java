package may.dualmatch;

/**
 * @author liubr
 * @date 2022/11/20 11:09
 */
public class Week_320_1NumberUnequalTripletsArray {

	public static void main(String[] args) {

	}

	public int unequalTriplets(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (i < j && j < k && nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) { {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

}
