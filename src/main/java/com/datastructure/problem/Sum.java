package com.datastructure.problem;

/**
 * 
 *<p>Description:计算arr[l......n)区间的内所有数字和<p>	
 * @author Administrator
 * @version 2020-10-28
 *
 */
public class Sum {
	
	public static int sum(int[] arr) {
		return sum(arr, 0);
	}
	
	private static int sum(int[] arr, int l) {
		if(l == arr.length) {return 0;}
		return arr[l] + sum(arr, l + 1);
	}
	
	public static void main(String[] args) {
		int [] nums = {1,2,3,4};
		System.out.println(sum(nums));
	}

}
