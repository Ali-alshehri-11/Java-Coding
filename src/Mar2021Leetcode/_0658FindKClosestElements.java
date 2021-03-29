package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _0658FindKClosestElements {

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int diff1 = Math.abs(o1 - x);
				int diff2 = Math.abs(o2 - x);
				if (diff1 != diff2) {
					return diff1 - diff2;
				}
				return o1 - o2;
			}
		});
		list = list.subList(0, k);
		Collections.sort(list);
		return list;
	}

}
