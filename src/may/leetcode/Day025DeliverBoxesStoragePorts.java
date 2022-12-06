package may.leetcode;

import java.util.PriorityQueue;

/**
 * @author liubr
 * @date 2022/12/06 16:34
 * 1687. 从仓库到码头运输箱子
 */
public class Day025DeliverBoxesStoragePorts {
	public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
		int n = boxes.length, dp = 0;
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		int dif = 0, wei = 0;
		for (int i = 1; i <= n; i++) {
			int cur = dp + 2;
			dif += i >= 2 && boxes[i - 1][0] != boxes[i - 2][0] ? 1 : 0;
			wei += boxes[i - 1][1];
			q.add(new int[]{i, cur - dif, boxes[i - 1][1] - wei});
			while (q.peek()[0] <= i - maxBoxes || q.peek()[2] + wei > maxWeight) {
				q.poll();
			}
			dp = q.peek()[1] + dif;
		}
		return dp;
	}
}
