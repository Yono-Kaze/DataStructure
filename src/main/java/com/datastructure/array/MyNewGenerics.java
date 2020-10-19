package com.datastructure.array;

/**
 * 
 *<p>Title:自定义泛型<p>	
 *<p>Description:将自定义数组通过泛型来支持所有类型数据<p>	
 * @author Administrator
 * @version 2020-10-11
 *
 */
public class MyNewGenerics<E> {
	private E[] data;
	private int size;//泛型中当前元素数量
	
	/**
	 * 
	 * <p>Description:设置一个默认的泛型大小10<p>
	 */
	public MyNewGenerics() {
		this(10);
	}
	
	/**
	 * 
	 * <p>Description:用户输入的泛型大小capacity<p>
	 * @param capacity
	 */
	public MyNewGenerics(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * <p>Description:返回泛型中当前元素个数<p>
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * <p>Description:返回泛型的容量<p>
	 * @return data.length
	 */
	public int getCapacity() {
		return data.length;
	}
	
	/**
	 * <p>Description:true泛型为空。false不为空<p>
	 * @return size == 0
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * <p>在所有元素后添加一个新元素<p>
	 * @param e
	 */
	public void addLast(E e) {
		addIndex(size,e);
	}
	
	/**
	 * <p>在所有元素前添加一个新元素<p>
	 * @param e
	 */
	public void addFirst(E e) {
		addIndex(0,e);
	}
	
	/**
	 * <p>按用户输入的索引添加新元素</p>
	 * @param index
	 * @param e
	 */
	public void addIndex(int index, E e) {
		
		if(index < 0 || index > size) {throw new IllegalArgumentException("add failed, index < 0 || index > size");}
		
		if(size == data.length) {reGenerics(data.length * 2);}//���ݿռ䣬��Ÿ��������
		
		for(int i = size - 1; i > index; i--) {data[i + 1] = data[i];}
		
		data[index] = e;
		size++;
	}
	

	/**
	 * <p>按输入的索引得到泛型中的元素</p>
	 * @param index
	 * @return data[index]
	 */
	public E get(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("get failed,index < 0 || index > size");}
		return data[index];
	}
	
	/**
	 *<p>返回泛型数组中第一个元素</p>
	 * @return
	 */
	public E getFirst() {
		return get(0);
	}
	
	/**
	 *<p>返回泛型数组中最后个元素</p>
	 * @return
	 */
	public E getLast() {
		return get(size - 1);
	}
	
	/**
	 * <p>按输入的索引修改泛型中的元素</p>
	 * @param index
	 * @param e
	 */
	public void set(int index, E e) {
		data[index] = e;
	}
	
	/**
	 * <p>按输入的数字查找泛型中是否有该元素,存在返回true，不存在返回false</p>
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e)) {return true;}
		}
		return false;
	}
	
	/**
	 * <p>按输入的数字查找泛型中是否有该元素，并返回索引，不存在则返回-1</p>
	 * @return
	 */
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e)) {return i;}
		}
		return -1;
	}
	
	/**
	 * <p>按输入索引删除元素，删除后返回删除元素</p>
	 * @return
	 */
	public E remove(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("remove failed,index < 0 || index > size");}
		E e = data[index];
		for(int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
		
		if(size == data.length / 4 && data.length / 2 != 0 ) {reGenerics(data.length / 2);}//���������������˷�
		
		return e;
	}
	
	/**
	 * <p>删除第一个元素，并返回删除元素</p>
	 * @return
	 */
	public E removeFirst() {return remove(0);}
	
	/**
	 * <p>删除最后一个元素，并返回删除元素</p>
	 * @return
	 */
	public E removeLast() {return remove(size - 1);}
	
	/**
	 * <p>对数组容量进行修改</p>
	 */
	private void reGenerics(int newCapacity) {
		// TODO Auto-generated method stub

		E[] newData = (E[]) new Object[newCapacity];
		
		for(int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		
		data = newData;
	}
	
	@Override
	public String toString() {
		
		StringBuffer res = new StringBuffer();
		res.append(String.format("Generics size = %d, capacity = %d\n", size, data.length));
		res.append('[');
		for(int i =  0; i < size; i++) {
			res.append(data[i]);
			if(i != size - 1) {res.append(',');}
		}
		res.append(']');
		return res.toString();
	}

}
