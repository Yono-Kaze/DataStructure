package com.datastructure.setandmap;

/**
 * 
 *<p>Description:集合的接口<p>	
 * @author Administrator
 * @version 2020-11-7
 *
 * @param <E>
 */
public interface Set<E>{
	
	void add(E e);
	void remove(E e);
	boolean contains(E e);
	int getSize();
	boolean isEmpty();

}
