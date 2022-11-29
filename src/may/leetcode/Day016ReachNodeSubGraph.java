package may.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author liubr
 * @date 2022/11/29 14:47
 * 882. 细分图中的可到达节点
 */
public class Day016ReachNodeSubGraph {

	static int N = 3010, M = 20010, INF = 0x3f3f3f3f, idx = 0;
	static int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
	static int[] dist = new int[N];
	static boolean[] vis = new boolean[N];

	void add(int a, int b, int c) {
		e[idx] = b;
		ne[idx] = he[a];
		w[idx] = c;
		he[a] = idx++;
	}

	public int reachableNodes(int[][] edges, int max, int n) {
		// 建图
		Arrays.fill(he, -1);
		idx = 0;
		for (int[] info : edges) {
			int a = info[0], b = info[1], c = info[2] + 1;
			add(a, b, c);
			add(b, a, c);
		}
		// SPFA
		Arrays.fill(dist, INF);
		Arrays.fill(vis, false);
		Deque<Integer> d = new ArrayDeque<>();
		d.addLast(0);
		dist[0] = 0;
		vis[0] = true;
		while (!d.isEmpty()) {
			int t = d.pollFirst();
			vis[t] = false;
			for (int i = he[t]; i != -1; i = ne[i]) {
				int j = e[i];
				if (dist[j] > dist[t] + w[i]) {
					dist[j] = dist[t] + w[i];
					if (vis[j]) {
						continue;
					}
					d.addLast(j);
					vis[j] = true;
				}
			}
		}
		// 统计答案
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (dist[i] <= max) {
				ans++;
			}
		}
		for (int[] info : edges) {
			int a = info[0], b = info[1], c = info[2];
			int c1 = Math.max(0, max - dist[a]), c2 = Math.max(0, max - dist[b]);
			ans += Math.min(c, c1 + c2);
		}
		return ans;
	}

}
