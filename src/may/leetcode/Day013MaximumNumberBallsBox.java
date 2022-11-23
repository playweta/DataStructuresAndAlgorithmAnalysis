package may.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubr
 * @date 2022/11/23 10:58
 * 1742. 盒子中小球的最大数量
 */
public class Day013MaximumNumberBallsBox {
	public static void main(String[] args) {
		System.out.println(new Day013MaximumNumberBallsBox().countBalls(19, 32));
	}

	public int countBalls(int lowLimit, int highLimit) {
		int[] arr = new int[46];
		while (lowLimit <= highLimit) {
			int ll = lowLimit;
			int a = 0;
			while (lowLimit > 0) {
				a += lowLimit % 10;
				lowLimit /= 10;
			}
			arr[a]++;
			lowLimit = ll + 1;
		}
		int min = Integer.MIN_VALUE;
		for (int a : arr) {
			min = Math.max(min, a);
		}
		return min;
	}

	public int countBall(int lowLimit, int highLimit) {
		int[] resultMap = new int[46];
		int firstIndex = 0, result = 0;
		for (int num = lowLimit; num > 0; num = num / 10) {
			firstIndex += num % 10;
		}
		// 初始化第一个数字lowLimit所在编号盒子的小球数量
		resultMap[firstIndex] = 1;
		for (int i = lowLimit; i < highLimit; i++) {
			// 根据前一个数的末位是否为9，来重新定位下一个数的位置
			for (int prevNum = i; prevNum % 10 == 9; prevNum /= 10) {
				// 前移9位
				firstIndex -= 9;
			}
			resultMap[++firstIndex]++;
		}
		for (int rm : resultMap) {
			result = Math.max(result, rm);
		}
		return result;
	}

}



