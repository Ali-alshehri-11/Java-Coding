package June2021GoogLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _0076MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
	}

	public static String minWindow(String s, String t) {
		String minString = "";
		int minLen = Integer.MAX_VALUE;
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			tMap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();

		int left = 0, right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);

			while (isMapEqual(sMap, tMap)) {
				c = s.charAt(left);
				sMap.put(c, sMap.get(c) - 1);
				if (sMap.get(c) == 0)
					sMap.remove(c);

				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					minString = s.substring(left, right + 1);
				}
				left++;
			}
			right++;
		}
		return minString;
	}

	public static boolean isMapEqual(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
		for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
			if (!sMap.containsKey(entry.getKey()))
				return false;

			if (sMap.get(entry.getKey()).intValue() < entry.getValue().intValue())
				return false;
		}
		return true;
	}
}
