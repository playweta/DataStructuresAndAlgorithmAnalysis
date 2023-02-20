package may.leetcode2023;

/**
 * @author liubr
 * @date 2023/02/20 11:35 上午
 * 2347. 最好的扑克手牌
 */
public class Day009_2347 {
	public String bestHand(int[] ranks, char[] suits) {
		boolean flush = true;
		for (int i = 1; i < 5 && flush; ++i) {
			flush = suits[i] == suits[i - 1];
		}
		if (flush) {
			return "Flush";
		}
		int[] cnt = new int[14];
		boolean pair = false;
		for (int x : ranks) {
			if (++cnt[x] == 3) {
				return "Three of a Kind";
			}
			pair = pair || cnt[x] == 2;
		}
		return pair ? "Pair" : "High Card";
	}
}
