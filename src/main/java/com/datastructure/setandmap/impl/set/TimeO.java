package com.datastructure.setandmap.impl.set;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import com.datastructure.setandmap.Set;
import com.datastructure.unit.FileOperation;

/**
 * 
 *<p>Description:集合的算法复杂度测试<p>	
 * @author Administrator
 * @version 2020-11-9
 *
 */
public class TimeO {
	private static double testSet(Set<String> set, String fileName) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		System.out.println(fileName);
		ArrayList<String> words = new ArrayList<String>();
		if(FileOperation.readFile(fileName, words)) {
			System.out.println("Total words" + words.size());

			for (String word : words) {
				set.add(word);
			}
			System.out.println("Total different words" + set.getSize());
		}

		long endTime = System.currentTimeMillis();

		return (endTime - startTime);
	}

	public static void main(String[] args) throws FileNotFoundException {

		String fileName = "file2.txt";

		Set<String> bstSet = new BSTSet<String>();
		double time1 = testSet(bstSet, fileName);
		System.out.println("BSTSet:" + time1);
		System.out.println("=======================");
		Set<String> linkedSet = new LinkedListSet<String>();
		double time2 = testSet(linkedSet, fileName);
		System.out.println("LinkedListSet:" + time2);
	}

}
