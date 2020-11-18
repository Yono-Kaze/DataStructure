package com.datastructure.problem;

/**
 * 
 *<p>Description:307. Range Sum Query - Mutable<p>	
 * @author Administrator
 * @version 2020-11-18
 *
 */
public class NumArrayG {

	private int[] data;
	private int[] sum; //sum[i]存储前i个元素的和，sum[0] = 0 ,sum[i] 存储nums[0....i-1]的和

	public NumArrayG(int[] nums) {
		
		data = new int[nums.length];
		
		for (int i = 1; i < nums.length; i++) {
			data[i] = nums[i];
		}

		sum = new int[nums.length + 1];
		sum[0] = 0;

		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
	}

	public void update(int index, int val) {

		data[index] = val;

		for (int i = index + 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + data[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}

}
