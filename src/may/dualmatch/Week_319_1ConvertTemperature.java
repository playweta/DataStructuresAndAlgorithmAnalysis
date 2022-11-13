package may.dualmatch;

import java.util.Arrays;

/**
 * 第 319 场周赛
 * 6234. 最小公倍数为 K 的子数组数目
 * @author liubr
 * @date 2022/11/13 10:31
 */
public class Week_319_1ConvertTemperature {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Week_319_1ConvertTemperature().convertTemperature(122.11)));
	}

	public double[] convertTemperature(double celsius) {
		return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
	}
}
