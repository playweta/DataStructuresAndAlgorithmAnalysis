package may.leetcode2023;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubr
 * @date 2023/02/18 17:03 下午
 */

class CustomFunction {
	// Returns f(x, y) for any given positive integers x and y.
	// Note that f(x, y) is increasing with respect to both x and y.
	// i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
	public int f(int x, int y) {
		return 0;
	}
}

public class Day007_1237 {
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		var ans = new ArrayList<List<Integer>>();
		int x = 1, y = 1000;
		while (x <= 1000 && y > 0) {
			int res = customfunction.f(x, y);
			if (res < z) {
				++x;
			} else if (res > z) {
				--y;
			} else {
				ans.add(List.of(x++, y--));
			}
		}
		return ans;
	}
}
