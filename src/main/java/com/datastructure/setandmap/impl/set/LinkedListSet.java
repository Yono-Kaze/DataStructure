package com.datastructure.setandmap.impl.set;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.datastructure.linkedlist.MyLinkedList;
import com.datastructure.setandmap.Set;
import com.datastructure.unit.FileOperation;

/**
 * 
 *<p>Description:集合(链表实现)<p>	
 * @author Administrator
 * @version 2020-11-7
 *
 * @param <E>
 */
public class LinkedListSet<E> implements Set<E> {
	
	private MyLinkedList<E> list;
	
	
	public LinkedListSet() {
		list = new MyLinkedList<>();
	}

	@Override
	public void add(E e) {
		
		if(!list.contains(e)) {
			list.addFirst(e);
		}
	}

	@Override
	public void remove(E e) {
		list.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("file1");
		ArrayList<String> words1 = new ArrayList<String>();
		FileOperation.readFile("file1.txt", words1);
		System.out.println("Total words" + words1.size());
		Set<String> set1 = new LinkedListSet<String>();
		for(String word: words1) {
			set1.add(word);
		}
		System.out.println("Total set1 words" + set1.getSize());
//		System.out.println("file2");
//		ArrayList<String> words2 = new ArrayList<String>();
//		FileOperation.readFile("file1.txt", words2);
//		System.out.println("Total words" + words2.size());
//		Set<String> set2 = new LinkedListSet<String>();
//		for(String word: words2) {
//			set2.add(word);
//		}
//		System.out.println("Total set1 words" + words2.size());
		
	}

}
