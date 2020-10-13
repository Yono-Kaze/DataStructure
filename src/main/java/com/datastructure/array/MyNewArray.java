package com.datastructure.array;

/**
 * 
 *<p>Title:自定义的数组类<p>	
 *<p>Description:将实现基本的增删查改等操作<p>	
 * @author Administrator
 * @version 2020-10-11
 *
 */
public class MyNewArray {
	private int[] data;
	private int size;//数组中当前元素数量
	
	/**
	 * 
	 * <p>Description:设置一个默认的数组大小10<p>
	 */
	public MyNewArray() {
		this(10);
	}
	
	/**
	 * 
	 * <p>Description:用户输入的数组大小capacity<p>
	 * @param capacity
	 */
	public MyNewArray(int capacity) {
		data = new int[capacity];
		size = 0;
	}
	
	/**
	 * <p>Description:返回数组中当前元素个数<p>
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * <p>Description:返回数组的容量<p>
	 * @return data.length
	 */
	public int getCapacity() {
		return data.length;
	}
	
	/**
	 * <p>Description:true数组为空。false不为空<p>
	 * @return size == 0
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * <p>在所有元素后添加一个新元素<p>
	 * @param e
	 */
	public void addLast(int e) {
		addIndex(size,e);
	}
	
	/**
	 * <p>在所有元素前添加一个新元素<p>
	 * @param e
	 */
	public void addFirst(int e) {
		addIndex(0,e);
	}
	
	/**
	 * <p>按用户输入的索引添加新元素</p>
	 * @param index
	 * @param e
	 */
	public void addIndex(int index, int e) {
		
		if(size == data.length) {throw new IllegalArgumentException("add failed,array is full");}
		
		if(index < 0 || index > size) {throw new IllegalArgumentException("add failed, index < 0 || index > size");}
		
		for(int i = size - 1; i > index; i--) {data[i + 1] = data[i];}
		
		data[index] = e;
		size++;
	}
	
	/**
	 * <p>按输入的索引得到数组中的元素</p>
	 * @param index
	 * @return data[index]
	 */
	public int get(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("get failed,index < 0 || index > size");}
		return data[index];
	}
	
	/**
	 * <p>按输入的索引修改数组中的元素</p>
	 * @param index
	 * @param e
	 */
	public void set(int index, int e) {
		data[index] = e;
	}
	
	/**
	 * <p>按输入的数字查找数组中是否有该元素,存在返回true，不存在返回false</p>
	 * @param e
	 * @return
	 */
	public boolean contains(int e) {
		for(int i = 0; i < size; i++) {
			if(data[i] == e) {return true;}
		}
		return false;
	}
	
	/**
	 * <p>按输入的数字查找数组中是否有该元素，并返回索引，不存在则返回-1</p>
	 * @return
	 */
	public int find(int e) {
		for(int i = 0; i < size; i++) {
			if(data[i] == e) {return i;}
		}
		return -1;
	}
	
	/**
	 * <p>按输入索引删除元素，删除后返回删除元素</p>
	 * @return
	 */
	public int remove(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("remove failed,index < 0 || index > size");}
		int e = data[index];
		for(int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return e;
	}
	
	/**
	 * <p>删除第一个元素，并返回删除元素</p>
	 * @return
	 */
	public int removeFirst() {return remove(0);}
	
	/**
	 * <p>删除最后一个元素，并返回删除元素</p>
	 * @return
	 */
	public int removeLast() {return remove(size - 1);}
	
	@Override
	public String toString() {
		
		StringBuffer res = new StringBuffer();
		res.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
		res.append('[');
		for(int i =  0; i < size; i++) {
			res.append(data[i]);
			if(i != size - 1) {res.append(',');}
		}
		res.append(']');
		return res.toString();
	}

}
