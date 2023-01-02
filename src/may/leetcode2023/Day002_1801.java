package may.leetcode2023;

import java.util.PriorityQueue;

/**
 * @author liubr
 * @date 2023/01/02 16:31 下午
 */
public class Day002_1801 {
	int mod = (int) 1e9 + 7;

	public int getNumberOfBacklogOrders(int[][] orders) {
		long ans = 0;
		//a[0] < b[0] ? -1 : 1默认小根堆，a[0] < b[0] ? 1 : -1 大根堆
		PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] < b[0] ? -1 : 1), buy = new PriorityQueue<>((a, b) -> a[0] < b[0] ? 1 : -1);
		for (int[] o : orders) {
			if (o[2] == 0) {
				//从sell backlog中寻找订单
				solove(sell, buy, o, true);
			} else {
				//从buy backlog中寻找订单
				solove(buy, sell, o, false);
			}
		}
		while (!buy.isEmpty()) {
			ans += buy.poll()[1];
		}
		while (!sell.isEmpty()) {
			ans += sell.poll()[1];
		}
		return (int) (ans % mod);
	}

	void solove(PriorityQueue<int[]> q1, PriorityQueue<int[]> q2, int[] o, boolean ok) {
		//通过ok判断价格是大于等于还是小于等于
		while (!q1.isEmpty() && o[1] != 0 && (ok ? q1.peek()[0] <= o[0] : q1.peek()[0] >= o[0])) {
			int[] t = q1.poll();
			//取两者中数量最少的
			int cnt = Math.min(o[1], t[1]);
			o[1] -= cnt;
			t[1] -= cnt;
			if (t[1] > 0) {
				//若数量还有剩，继续放入堆中
				q1.add(t);
			}
		}
		if (o[1] > 0) {
			//若订单还有剩，放入backlog中
			q2.add(new int[]{o[0], o[1]});
		}
	}
}
