package may.leetcode2023;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liubr
 * @date 2023/03/03 17:01 下午
 * 1487. 保证文件名唯一
 */
public class Day015_1487 {
	public String[] getFolderNames(String[] names) {
		Map<String, Integer> d = new HashMap<>();
		for (int i = 0; i < names.length; ++i) {
			if (d.containsKey(names[i])) {
				int k = d.get(names[i]);
				while (d.containsKey(names[i] + "(" + k + ")")) {
					++k;
				}
				d.put(names[i], k);
				names[i] += "(" + k + ")";
			}
			d.put(names[i], 1);
		}
		return names;
	}
}
