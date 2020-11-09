package com.datastructure.setandmap.impl.map;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.rmi.CORBA.Tie;

import com.datastructure.setandmap.Map;
import com.datastructure.unit.FileOperation;

/**
 * 
 *<p>Description:基于链表实现的map<p>	
 * @author Administrator
 * @version 2020-11-9 
 *
 */
public class LinkedListMap<K, V> implements Map<K, V>{

	private class Node{

		public K key;
		public V value;
		public Node next;

		public Node() {
			this.key = null;
			this.value = null;
			this.next = null;
		}

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node(K key) {
			this.key = key;
			this.value = null;
			this.next = null;
		}

		@Override
		public String toString() {
			return key.toString() + ":" + value.toString();
		}
	}

	private Node dummyHead;
	private int size;
	
	

	public LinkedListMap() {
		dummyHead = new Node();
		size = 0;
	}

	@Override
	public void add(K key, V value) {

		Node node = getNode(key);

		if(node == null) {
			dummyHead.next = new Node(key, value, dummyHead.next);
			size++;
		}else {
			node.value = value;
		}
	}

	@Override
	public V remove(K key) {

		Node prev = dummyHead;

		while(prev.next != null) {
			if(prev.next.key.equals(key)) {
				break;
			}
			prev = prev.next;
		}

		if(prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.value;
		}

		return null;
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	public Node getNode(K key) {

		Node cur = dummyHead.next;
		
		while (cur != null) {
			if(cur.key.equals(key)) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}

	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(key);
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
			Map<String, Integer> map = new LinkedListMap<String, Integer>();
			
			for (String word : words1) {
				if(map.contains(word)) { map.set(word, map.get(word) + 1);}
				else { map.add(word, 1);}
			}
			System.out.println("Total different words" + map.getSize());
			System.out.println("words:" + map.get("is"));
		}
	}

}
