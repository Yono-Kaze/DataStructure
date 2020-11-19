package com.datastructure.problem;

import java.util.TreeMap;


/**
 * 208. Implement Trie (Prefix Tree)
 *<p>Description:<p>	
 * @author Administrator
 * @version 2020-11-19
 *
 */
public class Trie {

	private class Node{

		public boolean isWord;//标志单词结束的标志
		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<Character, Trie.Node>();
		}

		public Node() {
			this(false);
		}
	}

	private Node root;
	private int size;

	public Trie() {
		root = new Node();
		size = 0;
	}

	/**
	 * 返回Trie中存储的单词数量
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 添加一个单词word
	 * @param word
	 */
	public void insert(String word) {

		Node cur = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}

		if (!cur.isWord) {
			cur.isWord = true;
			size++;
		}
	}

	/**
	 * 查询word是否在Trie中
	 * @return
	 */
	public boolean search(String word) {

		Node cur = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}	
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}

	/**
	 * 查询是否在Trie中有单词以prefix为前缀
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(String prefix) {

		Node cur = root;

		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}

			cur = cur.next.get(c);
		}

		return true;
	}


}
