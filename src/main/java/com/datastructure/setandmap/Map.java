package com.datastructure.setandmap;

/**
 * 
 *<p>Description:映射Map的接口<p>	
 * @author Administrator
 * @version 2020-11-9
 *
 */
public interface Map<K, V>{
	
	void add(K key, V value);
	V remove(K key);
	boolean contains(K key);
	V get(K key);
	void set(K key, V value);
	int getSize();
	boolean isEmpty();

}
