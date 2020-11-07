package com.datastructure.tree;

public class Test {
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		int[] nums = {5,3,6,8,4,2};
		for(int num:nums) {
			bst.add(num);
		}
		bst.preOrder();
	}

}
