package Dec2020Leetcode;

import java.util.HashMap;

public class _0340LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0, right = 0;
		int maxLength = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			map.compute(c, (key, v) -> v == null ? 1 : v + 1);
			while (map.size() > k) {
				char c1 = s.charAt(left);
				map.compute(c1, (key, v) -> v == null ? 0 : v - 1);
				if (map.get(c1) == 0) {
					map.remove(c1);
				}
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}
		return maxLength;
	}
}
