package com.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * 
 *<p>Description:自定义二分搜索树，泛型类型要求必须有可比较性，使用extends来限制类型，且不含重复节点<p>	
 * @author Administrator
 * @version 2020-10-29
 *
 */
public class BST<E extends Comparable<E>> {

	private class Node{
		public E e;
		public Node left, right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}		
	}

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 向二分搜索树中插入元素
	 * @param e
	 */
	public void add(E e) {
		root = add(root, e);
	}

	/**
	 * 向node为根节点的二分搜索树种插入元素E，使用递归
	 * @param node
	 * @param e
	 * @return Node
	 */
	private Node add(Node node, E e) {

		//		if(e.equals(node.e)) {return;}
		//		else if(node.e.compareTo(node.e) < 0 && node.left == null){
		//			node.left = new Node(e);
		//			size ++;
		//			return;
		//		}else if(node.e.compareTo(e) > 0 && node.right == null) {
		//			node.right = new Node(e);
		//			size ++;
		//			return;
		//		}
		//		if(node.e.compareTo(e) < 0) {
		//			 add(node.left, e);
		//		}
		//		else (node.e.compareTo(e) > 0){ 
		//			 add(node.right, e);
		//		}

		if(node == null) {
			size ++;
			return new Node(e);
		}
		if(e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}
		else if(e.compareTo(node.e) > 0){ 
			node.right = add(node.right, e);
		}

		return node;
	}

	/**
	 * 查看二分搜索树种是否包含元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		return contains(root, e);
	}

	/**
	 * 查看一node为跟的二分搜索树种是否包含元素e，递归算法
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node,E e) {
		if(node == null) {
			return false;
		}
		if(e.compareTo(node.e) == 0) {
			return true;
		}else if(e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		}else {
			return contains(node.right, e);
		}

	}

	/**
	 * 二分搜索树的前序遍历
	 */
	public void preOrder() {
		preOrder(root);
	}
	
	/**
	 * 二分搜索树的前序遍历,非递归算法
	 */
	public void preOrderN() {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			
			if(cur.right != null) {
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}
		
	}

	/**
	 *前序遍历以node为根的二分搜索树，递归算法
	 */
	private void preOrder(Node node) {
//		if(node == null) {
//			return;
//		}
//		System.out.println(node.e);
//		preOrder(node.left);
//		preOrder(node.right);
		
		if(node != null) {
			System.out.println(node.e);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/**
	 * 中序遍历
	 */
	public void inOrder() {
		inOrder(root);
	}
	
	/**
	 *中序遍历以node为根的二分搜索树，递归算法
	 */
	private void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.e);
			inOrder(node.right);
		}
		
	}

	/**
	 * 后序遍历
	 */
	public void lastOrder() {
		lastOrder(root);
	}
	
	/**
	 *后序遍历以node为根的二分搜索树，递归算法
	 */
	private void lastOrder(Node node) {
		if(node != null) {
			lastOrder(node.left);
			lastOrder(node.right);
			System.out.println(node.e);
		}
		
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}
	
	/**
	 * 生成以node为根节点，深度为depth的描述二叉树的字符串
	 * @param node
	 * @param depth
	 * @param res
	 */
	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if(node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}
		
		res.append(generateDepthString(depth) + node.e +"\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
		
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("-");
		}
		return res.toString();
	}
	
	/**
	 * 层序遍历
	 */
	public void levelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.e);
			
			if(cur.left != null) {
				queue.add(cur.left);
			}
			
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
	}
	
	/**
	 * 寻找最小元素
	 * @return
	 */
	public E minimum() {
		
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		
		return minimum(root).e;
	}
	
	/**
	 * 寻找最小元素
	 * @param Node
	 * @return
	 */
	private Node minimum(Node node) {
		if(node.left == null) {
			return node;
		}
		
		return minimum(node.left);
	}
	
	/**
	 * 寻找最大元素
	 * @return
	 */
	public E maxinimum() {
		
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		
		return maxinimum(root).e;
	}
	
	/**
	 * 寻找最大元素
	 * @param Node
	 * @return
	 */
	private Node maxinimum(Node node) {
		if(node.right == null) {
			return node;
		}
		
		return maxinimum(node.right);
	}
	
	/**
	 * 删除最小值节点，并返回
	 * @return
	 */
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}

	/**
	 * 删除以node为根最小值节点，并返回新的二分搜索树的根
	 * @return Node
	 */
	private Node removeMin(Node node) {
		
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		
		node.left = removeMin(node.left);
		return node;
	}
	
	/**
	 * 删除最大值节点，并返回
	 * @return
	 */
	public E removeMax() {
		E ret = minimum();
		root = removeMax(root);
		return ret;
	}

	/**
	 * 删除以node为根最大值节点，并返回新的二分搜索树的根
	 * @return Node
	 */
	private Node removeMax(Node node) {
		
		if(node.right == null) {
			Node lefthtNode = node.left;
			node.left = null;
			size--;
			return lefthtNode;
		}
		
		node.right = removeMin(node.right);
		return node;
	}
	
	/**
	 * 删除元素为e的节点
	 * @param e
	 */
	public void remove(E e) {
		root = remove(root, e);
	}

	/**
	 * 删除以node为根的树种值为e的节点
	 * @param node
	 * @param e
	 * @return
	 */
	private BST<E>.Node remove(BST<E>.Node node, E e) {
		
		if(node == null) {
			return null;
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		}else if(e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
		}else {//e == node.e
			
			//待删节点左子树为空
			if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			
			//待删节点右子树为空
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			
			//待删除节点左右自述均不为空，找到比该节点大的临近节点，即带删除节点右子树中最小的节点来替换
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			size++;
			node.left = node.right = null;
			return successor;
		}
		return null;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(2);
		bst.add(4);
		bst.add(2);
		System.out.println(bst);
//		int[] nums = {5,3,6,8,4,2};
//		for(int num:nums) {
//			bst.add(num);
//		}
//		System.out.println("---------前序递归------------");
//		bst.preOrder();
//		System.out.println("---------前序非递归------------");
//		bst.preOrderN();
//		System.out.println("----------中序------------");
//		bst.inOrder();
//		System.out.println("-----------后序------------");
//		bst.lastOrder();
//		System.out.println("-----------------------");
//		System.out.println(bst);
//		System.out.println("---------层序遍历------------");
//		bst.levelOrder();
//		Random random = new Random();
//		int n = 1000;
//		
//		for(int i = 0; i < n; i++) {
//			bst.add(random.nextInt(1000));
//		}
//		
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		while(!bst.isEmpty()) {
//			nums.add(bst.removeMin());
//		}
//		
//		System.out.println(nums);
//		
//		for (int i = 1; i < nums.size(); i++) {
//			if(nums.get(i - 1) > nums.get(i)) {
//				throw new IllegalArgumentException("Error");
//			}
//		}
//		System.out.println("removeMin test comppleted");
	}
	





}
