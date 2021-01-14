package Dec2020Leetcode;

import java.util.HashMap;
import java.util.TreeMap;

public class _0981TimeBasedKeyValueStore {

	public static void main(String[] args) {
		TimeMap kv = new TimeMap();
		kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
		System.out.println(kv.get("foo", 1)); // output "bar"
		System.out.println(kv.get("foo", 3)); // output "bar" since there is no value corresponding to foo at timestamp
												// 3 and
		// timestamp 2, then the only value is at timestamp 1 ie "bar"
		kv.set("foo", "bar2", 4);
		System.out.println(kv.get("foo", 4)); // output "bar2"
		System.out.println(kv.get("foo", 5)); // output "bar2"
	}

	static class TimeMap {
		HashMap<String, TreeMap<Integer, String>> map;

		/** Initialize your data structure here. */
		public TimeMap() {
			map = new HashMap<String, TreeMap<Integer, String>>();
		}

		public void set(String key, String value, int timestamp) {
			if (map.containsKey(key)) {
				map.get(key).put(timestamp, value);
			} else {
				TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
				tm.put(timestamp, value);
				map.put(key, tm);
			}
		}

		public String get(String key, int timestamp) {
			if (map.containsKey(key)) {
				if (map.get(key).containsKey(timestamp))
					return map.get(key).get(timestamp);
				else {
					Integer highertimestamp = map.get(key).floorKey(timestamp);
					if (highertimestamp == null) {
						return "";
					} else {
						return map.get(key).get(highertimestamp);
					}
				}
			}
			return "";
		}
	}

}
