package com.datastructure.problem;

import com.datastructure.segmenttree.SegmentTree;

/**
 * 
 *<p>Description:303. Range Sum Query - Immutable<p>	
 * @author Administrator
 * @version 2020-11-18
 *
 */
public class NumArray {
	
	private SegmentTree<Integer> segmentTree;
	
    public NumArray(int[] nums) {
        
    	if (nums.length > 0) {
			Integer[] data = new Integer[nums.length];
			
			for (int i = 0; i < nums.length; i++) {
				data[i] = nums[i];
			}
			
			segmentTree = new SegmentTree<Integer>(data, (a,b) -> a+b);
		}
    }
    
    public int sumRange(int i, int j) {
    	
		return segmentTree.query(i, j);
    }

}
