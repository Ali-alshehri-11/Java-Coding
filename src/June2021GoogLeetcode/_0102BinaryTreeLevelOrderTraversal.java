package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import May2021GoogLeetcode._0102BinaryTreeLevelOrderTraversal.TreeNode;

public class _0102BinaryTreeLevelOrderTraversal {
	public static class TreeNode {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(levelOrder(tn));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root != null)
			q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				list.add(tn.val);
				if (tn.left != null)
					q.offer(tn.left);
				if (tn.right != null)
					q.offer(tn.right);
			}
			output.add(list);
		}
		return output;
	}

}
