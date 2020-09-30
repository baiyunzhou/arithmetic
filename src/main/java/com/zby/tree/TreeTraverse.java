package com.zby.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 * 
 * @author zby
 *
 */
public class TreeTraverse {

	/**
	 * 树节点
	 * 
	 * @author zby
	 *
	 */
	static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

	/**
	 * 保留根节点，根据索引创建左右孩子，创建完成后放进queue，继续补充孩子
	 * 
	 * @param list
	 * @return
	 */
	public static TreeNode buildTree(List<Integer> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		int index = 0;
		TreeNode root = new TreeNode(list.get(0));
		int size = list.size();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (++index < size) {
				Integer val = list.get(index);
				if (val != null) {
					cur.left = new TreeNode(list.get(index));
					queue.offer(cur.left);
				}
			}
			if (++index < size) {
				Integer val = list.get(index);
				if (val != null) {
					cur.right = new TreeNode(val);
					queue.offer(cur.right);
				}
			}
		}
		return root;
	}

	/**
	 * 层序遍历
	 * 
	 * @return
	 */
	public static List<List<String>> levelOrder(TreeNode root) {
		List<List<String>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<String> inner = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = queue.poll();
				if (treeNode == null) {
					inner.add("n");
					continue;
				} else {
					inner.add(treeNode.val + "");
				}
				queue.add(treeNode.left);
				queue.add(treeNode.right);
			}
			list.add(inner);
		}
		return list;
	}

	/**
	 * 先序遍历-递归
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> preOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preOrder(root, list);
		return list;
	}

	private static void preOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

	/**
	 * 先序遍历-非递归
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> preOrderNoRecurse(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		// 深度优先，使用stack
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return list;
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> midOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		midOrder(root, list);
		return list;
	}

	private static void midOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		midOrder(root.left, list);
		list.add(root.val);
		midOrder(root.right, list);
	}

	/**
	 * 中序遍历-非递归(破坏树结构)
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> midOrderNoRecurse(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		// 深度优先，使用stack
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left == null && node.right == null) {
				list.add(node.val);
				continue;
			}
			if (node.right != null) {
				stack.push(node.right);
			}
			stack.push(node);
			if (node.left != null) {
				stack.push(node.left);
			}
			node.left = null;
			node.right = null;
		}
		return list;
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Deque<TreeNode> stk = new LinkedList<TreeNode>();
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			root = stk.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> postOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		postOrder(root, list);
		return list;
	}

	private static void postOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}

	/**
	 * 后序遍历-非递归
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> postOrderNoRecurse(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		// 深度优先，使用stack
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left == null && node.right == null) {
				list.add(node.val);
				continue;
			}
			stack.push(node);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			node.left = null;
			node.right = null;
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, null, 9, null, 10));
		System.out.println("层序遍历：" + levelOrder(root));
		System.out.println("先序遍历：" + preOrder(root));
		System.out.println("先序遍历：" + preOrderNoRecurse(root));
		System.out.println("中序遍历：" + midOrder(root));
		System.out.println("中序遍历：" + inorderTraversal(root));
		System.out.println("中序遍历：" + midOrderNoRecurse(root));// 破坏了树结构，需要重构
		root = buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, null, 9, null, 10));
		System.out.println("后序遍历：" + postOrder(root));
		System.out.println("后序遍历：" + postOrderNoRecurse(root));// 破坏了树结构，需要重构
	}

}
