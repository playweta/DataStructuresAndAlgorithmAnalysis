package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/21 15:09 下午
 * 2469. 温度转换
 */
public class Day027_2469 {
	public double[] convertTemperature(double celsius) {
		return new double[]{celsius + 273.15, celsius * 1.8 + 32};
	}
}
