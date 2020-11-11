package com.datastructure.problem;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 *<p>Description:349. Intersection of Two Arrays<p>	
 * Given two arrays, write a function to compute their intersection.
 * @author Administrator
 * @version 2020-11-11
 *
 */
public class Intersection {
	
	public int[] intersection(int[] nums1, int[] nums2) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for (Integer num : nums1) {
			set.add(num);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (Integer num : nums2) {
			if (set.contains(num)) {
				list.add(num);
				set.remove(num);
			}
		}
		
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		
		return res;
	}

}
