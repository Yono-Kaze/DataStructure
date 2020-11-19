package com.datastructure.trie;

import java.util.TreeMap;

/**
 * 
 *<p>Description:Trie(底层为TreeMap)<p>	
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
	public void add(String word) {

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
	public boolean contains(String word) {
		
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

}
