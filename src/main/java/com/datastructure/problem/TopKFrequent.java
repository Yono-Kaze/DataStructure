package com.datastructure.problem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;


/**
 * 
 *<p>Description:347. Top K Frequent Elements<p>
 *Given a non-empty array of integers, return the k most frequent elements.	
 * @author Administrator
 * @version 2020-11-14
 *
 */
public class TopKFrequent {
//	private static class Freq {
//		int e,freq;
//
//		public Freq(int e, int freq) {
//			this.e = e;
//			this.freq = freq;
//		}
//	}

	/**
	 * 
	 *<p>Description:频率比较器，<p>	
	 * @author Administrator
	 * @version 2020-11-14
	 *
	 */
//	private static class FreqComparator implements Comparator<Freq>{
//
//		@Override
//		public int compare(Freq o1, Freq o2) {
//			return o1.freq - o2.freq;
//		}
//		
//	}
	
	public static  int[] topKFrequent(int[] nums, int k) {

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for(int num: nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}else {
				map.put(num, 1);
			}
		}

//		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return map.get(o1) - map.get(o2);
//			}
//		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(a, b) -> map.get(a) - map.get(b));

		
		for (int key : map.keySet()) {
			if (pq.size() < k) {
				pq.add(key);
			}else if (map.get(key) > map.get(pq.peek())) {
				pq.poll();
				pq.add(key);
			} 
		}
		int size = pq.size();
		int[] num = new int[size] ;
		for (int i = 0; i < size; i++) {
			if (!pq.isEmpty()) {
				num[i] = pq.poll();
			}
		}
		return num;
	}

	public static void main(String[] args) {
		int[] a = {4,1,-1,2,-1,2,3};
		a = topKFrequent(a, 2);
		for (int i : a) {
			System.out.println(i);
		}
	}

}


