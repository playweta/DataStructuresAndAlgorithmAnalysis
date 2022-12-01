package may.leetcode;

import java.util.*;

/**
 * @author liubr
 * @date 2022/12/01 20:29
 * 895. 最大频率栈
 */
public class Day020MaximumFrequencyStack {

	private final Map<Integer, Integer> cnt = new HashMap<>();
	private final List<Deque<Integer>> stacks = new ArrayList<>();

	public void push(int val) {
		int c = cnt.getOrDefault(val, 0);
		// 这个元素的频率已经是目前最多的，现在又出现了一次
		if (c == stacks.size())
		{
			// 那么必须创建一个新栈
			stacks.add(new ArrayDeque<>());
		}
		stacks.get(c).push(val);
		// 更新频率
		cnt.put(val, c + 1);
	}

	public int pop() {
		int back = stacks.size() - 1;
		// 弹出最右侧栈的栈顶
		int val = stacks.get(back).pop();
		// 栈为空
		if (stacks.get(back).isEmpty()) {
			// 删除
			stacks.remove(back);
		}
		// 更新频率
		cnt.put(val, cnt.get(val) - 1);
		return val;
	}

}
