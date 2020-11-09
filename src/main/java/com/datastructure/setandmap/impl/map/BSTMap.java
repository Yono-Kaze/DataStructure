package com.datastructure.setandmap.impl.map;

import java.io.FileNotFoundException;
import java.util.ArrayList;


import com.datastructure.setandmap.Map;
import com.datastructure.unit.FileOperation;
/**
 * 
 *<p>Description:基于二分查找树实现的映射Map<p>	
 * @author Administrator
 * @version 2020-11-9
 *
 */
public class BSTMap <K extends Comparable<K>, V> implements Map<K, V>{

	private class Node{
		public K key;
		public V value;
		public Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}		
	}
	
	private Node root;
	private int size;
	
	public BSTMap() {
		root = null;
		size = 0;
	}
	
	@Override
	public void add(K key, V value) {
		root = add(root, key, value);
	}

	/**
	 * 向node为根节点的二分搜索树种插入元素(key, value)，使用递归
	 * @param node
	 * @param e
	 * @return Node
	 */
	private Node add(Node node, K key, V value) {

		if(node == null) {
			size ++;
			return new Node(key, value);
		}
		if(key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		}
		else if(key.compareTo(node.key) > 0){ 
			node.right = add(node.right, key, value);
		}else {
			//key.compareTo(node.key == 0)
			node.value = value;
		}

		return node;
	}
	
	/**
	 * 返回以node问根节点的二分搜索树，key所在的节点
	 * @param node
	 * @param key
	 * @return
	 */
	private Node getNode(Node node, K key) {
		
		if(node == null) {
			return null;
		}
		
		if(key.compareTo(node.key) == 0) {
			return node;
		}else if(key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		}else {
			//key.compareTo(node.key) > 0
			return getNode(node.right, key);
		}
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
	public Node removeMin() {
		Node ret = minimum();
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
	public Node removeMax() {
		Node ret = minimum();
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
	@Override
	public V remove(K key) {
		
		Node node = getNode(root, key);
		
		if(node != null) {
			root = remove(root, key);
			return node.value;
		}
		
		return null;
	}

	/**
	 * 删除以node为根的树种值为e的节点
	 * @param node
	 * @param e
	 * @return
	 */
	private Node remove(Node node, K key) {
		
		if(node == null) {
			return null;
		}
		
		if(key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		}else if(key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
		}else {//key.compareTo(node.key) == 0
			
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
	 * 寻找最小元素
	 * @return
	 */
	public Node minimum() {
		
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		
		return minimum(root);
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

	@Override
	public boolean contains(K key) {
		return getNode(root, key) != null;
	}

	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}

	/**
	 * 更新key对应的元素
	 */
	@Override
	public void set(K key, V value) {
		Node node = getNode(root, key);
		if(node == null) {
			throw new IllegalArgumentException(key + "doesn't exist");
		}
		node.value = value;
		
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("file1");
		ArrayList<String> words1 = new ArrayList<String>();
		
		if(FileOperation.readFile("file1.txt", words1)) {
			System.out.println("Total words" + words1.size());
			Map<String, Integer> map = new BSTMap<String, Integer>();
			
			for (String word : words1) {
				if(map.contains(word)) { map.set(word, map.get(word) + 1);}
				else { map.add(word, 1);}
			}
			System.out.println("Total different words" + map.getSize());
			System.out.println("words:" + map.get("is"));
		}
	}

}
