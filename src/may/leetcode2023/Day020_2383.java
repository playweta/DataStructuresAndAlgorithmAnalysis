package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/03/13 17:25 下午
 * 2383. 赢得比赛需要的最少训练时长
 */
public class Day020_2383 {
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
		int minHours = 0, totalEnergy = 0;
		for (int e : energy) {
			totalEnergy += e;
		}
		minHours = totalEnergy - initialEnergy >= 0 ? totalEnergy - initialEnergy + 1 : 0;
		for (int e : experience) {
			if (initialExperience <= e) {
				minHours += e - initialExperience + 1;
				initialExperience = e + 1;
			}
			initialExperience += e;
		}
		return minHours;
	}
}
