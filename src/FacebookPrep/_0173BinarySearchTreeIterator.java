package FacebookPrep;

import java.util.Stack;

public class _0173BinarySearchTreeIterator {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(7);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(15);
		tn.right.left = new TreeNode(9);
		tn.right.right = new TreeNode(20);

		BSTIterator iterator = new BSTIterator(tn);
		System.out.println(iterator.next()); // return 3
		System.out.println(iterator.next()); // return 7
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 9
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 15
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 20
		System.out.println(iterator.hasNext()); // return false
	}

	static class BSTIterator {
		Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			if (root == null)
				return;
			stack = new Stack<TreeNode>();
			addLeftNodes(root);
		}

		public void addLeftNodes(TreeNode root) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}

		public int next() {
			if (!stack.isEmpty()) {
				TreeNode tn = stack.pop();
				addLeftNodes(tn.right);
				return tn.val;
			}
			return -1;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}
}