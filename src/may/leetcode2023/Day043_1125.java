package may.leetcode2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liubr
 * @date 2023/04/08 23:52 下午
 * 1125. 最小的必要团队
 */
public class Day043_1125 {
	public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
		var sid = new HashMap<String, Integer>();
		int m = reqSkills.length;
		for (int i = 0; i < m; ++i)
			sid.put(reqSkills[i], i); // 字符串映射到下标

		int n = people.size();
		var mask = new int[n];
		for (int i = 0; i < n; ++i)
			for (var s : people.get(i)) // 把 people[i] 压缩成一个二进制数 mask[i]
				mask[i] |= 1 << sid.get(s);

		int u = 1 << m;
		var ids = new long[u]; // ids[j] 表示 f[j] 对应的 people 下标集合
		var f = new int[u]; // f[j] 表示并集为 j 至少要选的 people 个数
		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 0;
		for (int j = 0; j < u - 1; ++j) // f[u-1] 无需计算
			if (f[j] < Integer.MAX_VALUE)
				for (int i = 0; i < n; ++i)
					if (f[j] + 1 < f[j | mask[i]]) {
						f[j | mask[i]] = f[j] + 1; // 刷表：用 f[j] 去更新其它状态
						ids[j | mask[i]] = ids[j] | (1L << i);
					}

		long res = ids[u - 1];
		var ans = new int[Long.bitCount(res)];
		for (int i = 0, j = 0; i < n; ++i)
			if (((res >> i) & 1) > 0)
				ans[j++] = i; // 所有在 res 中的下标
		return ans;
	}
}
