package LeetcodeTemplate;

public class _0598RangeAdditionII {

	public static void main(String[] args) {
		System.out.println(maxCount(3, 3, new int[][] { new int[] { 2, 2 }, new int[] { 3, 3 } }));
		System.out.println(maxCount(3, 3,
				new int[][] { new int[] { 2, 2 }, new int[] { 3, 3 }, new int[] { 3, 3 }, new int[] { 3, 3 },
						new int[] { 2, 2 }, new int[] { 3, 3 }, new int[] { 3, 3 }, new int[] { 3, 3 },
						new int[] { 2, 2 }, new int[] { 3, 3 }, new int[] { 3, 3 }, new int[] { 3, 3 } }));
		System.out.println(maxCount(3, 3, new int[][] {}));
	}

	
}
