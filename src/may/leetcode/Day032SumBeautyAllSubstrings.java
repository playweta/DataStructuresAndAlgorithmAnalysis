package may.leetcode;

/**
 * @author liubr
 * @date 2022/12/12 14:23 下午
 * 1781. 所有子字符串美丽值之和
 */
public class Day032SumBeautyAllSubstrings {
	public static void main(String[] args) {
		System.out.println(new Day032SumBeautyAllSubstrings().beautySum("pgljlqegfyqhs"));
	}

	public int beautySum(String s) {
		int ans = 0;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			int[] cnt = new int[26];
			for (int j = i; j < n; ++j) {
				++cnt[s.charAt(j) - 'a'];
				int mi = 1000, mx = 0;
				for (int v : cnt) {
					if (v > 0) {
						mi = Math.min(mi, v);
						mx = Math.max(mx, v);
					}
				}
				ans += mx - mi;
			}
		}
		return ans;
	}

	public int beautySumD(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] arr = new int[26];
			int max = 0;
			for (int j = i; j < s.length(); j++) {
				++arr[s.charAt(j) - 'a'];
				max = Math.max(max, arr[s.charAt(j) - 'a']);
				int min = s.length();
				for (int k = 0; k < 26; k++) {
					if (arr[k] > 0) {
						min = Math.min(min, arr[k]);
					}
				}
				count += max - min;
			}
		}
		return count;
	}
}
