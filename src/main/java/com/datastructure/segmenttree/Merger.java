package com.datastructure.segmenttree;

/**
 * 
 *<p>Description:对传入进行操作的接口<p>	
 * @author Administrator
 * @version 2020-11-14
 *
 */
public interface Merger<E> {
	/**
	 * 给定两个参数，将其合并成一个类型并且返回
	 * @param a
	 * @param b
	 * @return
	 */
	E merge(E a, E b);
}
