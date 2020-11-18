package com.datastructure.problem;

import com.datastructure.segmenttree.SegmentTree;

/**
 * 
 *<p>Description:307. Range Sum Query - Mutable<p>	
 * @author Administrator
 * @version 2020-11-18
 *
 */
public class NumArrayG {

	private SegmentTree<Integer> segmentTree;
	
    public NumArrayG(int[] nums) {
        
    	if (nums.length > 0) {
			Integer[] data = new Integer[nums.length];
			
			for (int i = 0; i < nums.length; i++) {
				data[i] = nums[i];
			}
			
			segmentTree = new SegmentTree<Integer>(data, (a,b) -> a+b);
		}
    }
    
    public void update(int i, int val) {
    	if(segmentTree == null) {
    		throw new IllegalArgumentException("segmentTree is null");
    	}
    	
    	segmentTree.set(i, val);
    }
    
    public int sumRange(int i, int j) {
    	
		return segmentTree.query(i, j);
    }

}
