package com.datastructure.trie;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.datastructure.setandmap.impl.set.BSTSet;
import com.datastructure.unit.FileOperation;

/**
 * 
 *<p>Description:比较Trie和集合(底层为二分搜索树)的时间复杂度<p>	
 * @author Administrator
 * @version 2020-11-19
 *
 */
public class TimeO {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("file2.txt");

		ArrayList<String> words = new ArrayList<String>();
		if (FileOperation.readFile("file2.txt", words)) {

			long startTime = System.currentTimeMillis();
			BSTSet<String> set = new BSTSet<String>();
			
			for (String word : words) {
				set.add(word);
			}

			for (String word : words) {
				set.contains(word);
			}

			long endtTime = System.currentTimeMillis();
			Double time = (double) (endtTime - startTime);
			System.out.println("different words" + set.getSize());
			System.out.println("BSTSet: " + time);

			//---

			startTime = System.currentTimeMillis();
			Trie trie = new Trie();
			
			for (String word : words) {
				trie.add(word);
			}

			for (String word : words) {
				trie.contains(word);
			}

			endtTime = System.currentTimeMillis();
			time = (double) (endtTime - startTime);
			System.out.println("different words" + set.getSize());
			System.out.println("Trie: " + time);
		}
	}

}
