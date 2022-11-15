package may.leetcode;

import java.util.Arrays;

/**
 * @author liubr
 * @date 2022/11/15 10:30
 * <p>
 * 1710. 卡车上的最大单元数
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载箱子的最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * 返回卡车可以装载单元 的 最大 总数。
 */
public class Day005MaximumUnitsTruck {
	public static void main(String[] args) {
		System.out.println(new Day005MaximumUnitsTruck().maximumUnits(new int[][]{{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}}, 13));
	}

	/**
	 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
	 * 内存消耗：41.3 MB, 在所有 Java 提交中击败了96.19%的用户
	 * 通过测试用例： 76 / 76
	 *
	 * @param boxTypes  boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]
	 * @param truckSize 表示卡车上可以装载箱子的最大数量
	 * @return 卡车可以装载单元的最大总数。
	 */
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		int curd = 0;
		int[] arr = new int[1001];
		for (int[] boxType : boxTypes) {
			arr[boxType[1]] += boxType[0];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				if (truckSize > arr[i]) {
					curd += i * arr[i];
					truckSize -= arr[i];
				} else {
					return curd + i * truckSize;
				}
			}
		}
		return curd;
	}

	/**
	 * @param boxTypes
	 * @param truckSize
	 * @return
	 */
	public int maximumUnitsSort(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
		int res = 0;
		for (int[] boxType : boxTypes) {
			int numberOfBoxes = boxType[0];
			int numberOfUnitsPerBox = boxType[1];
			if (numberOfBoxes < truckSize) {
				res += numberOfBoxes * numberOfUnitsPerBox;
				truckSize -= numberOfBoxes;
			} else {
				res += truckSize * numberOfUnitsPerBox;
				break;
			}
		}
		return res;
	}
}
