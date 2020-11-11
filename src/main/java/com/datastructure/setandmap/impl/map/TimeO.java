package com.datastructure.setandmap.impl.map;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.datastructure.setandmap.Map;
import com.datastructure.unit.FileOperation;

/**
 * 
 *<p>Description:映射的算法复杂度测试<p>	
 * @author Administrator
 * @version 2020-11-9
 *
 */
public class TimeO {
	private static double testMap(Map<String, Integer> map, String fileName) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		System.out.println(fileName);
		ArrayList<String> words = new ArrayList<String>();
		if(FileOperation.readFile(fileName, words)) {
			System.out.println("Total words" + words.size());

			for (String word : words) {
				if(map.contains(word)) {
					map.set(word, map.get(word) + 1);
				}
				else {
					map.add(word, 1);
				}
			}
			System.out.println("Total different words" + map.getSize());
		}

		long endTime = System.currentTimeMillis();

		return (endTime - startTime);
	}

	public static void main(String[] args) throws FileNotFoundException {

		String fileName = "file2.txt";

		Map<String, Integer> bstMap = new BSTMap<String, Integer>();
		double time1 = testMap(bstMap, fileName);
		System.out.println("BSTSet:" + time1 + "ms");
		System.out.println("=======================");
		Map<String, Integer> linkedMap = new LinkedListMap<String, Integer>();
		double time2 = testMap(linkedMap, fileName);
		System.out.println("LinkedListSet:" + time2 + "ms");
	}

}
