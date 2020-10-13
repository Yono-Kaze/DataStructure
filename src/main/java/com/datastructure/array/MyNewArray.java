package com.datastructure.array;

/**
 * 
 *<p>Title:�Զ����������<p>	
 *<p>Description:��ʵ�ֻ�������ɾ��ĵȲ���<p>	
 * @author Administrator
 * @version 2020-10-11
 *
 */
public class MyNewArray {
	private int[] data;
	private int size;//�����е�ǰԪ������
	
	/**
	 * 
	 * <p>Description:����һ��Ĭ�ϵ������С10<p>
	 */
	public MyNewArray() {
		this(10);
	}
	
	/**
	 * 
	 * <p>Description:�û�����������Сcapacity<p>
	 * @param capacity
	 */
	public MyNewArray(int capacity) {
		data = new int[capacity];
		size = 0;
	}
	
	/**
	 * <p>Description:���������е�ǰԪ�ظ���<p>
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * <p>Description:�������������<p>
	 * @return data.length
	 */
	public int getCapacity() {
		return data.length;
	}
	
	/**
	 * <p>Description:true����Ϊ�ա�false��Ϊ��<p>
	 * @return size == 0
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * <p>������Ԫ�غ����һ����Ԫ��<p>
	 * @param e
	 */
	public void addLast(int e) {
		addIndex(size,e);
	}
	
	/**
	 * <p>������Ԫ��ǰ���һ����Ԫ��<p>
	 * @param e
	 */
	public void addFirst(int e) {
		addIndex(0,e);
	}
	
	/**
	 * <p>���û���������������Ԫ��</p>
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
	 * <p>������������õ������е�Ԫ��</p>
	 * @param index
	 * @return data[index]
	 */
	public int get(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("get failed,index < 0 || index > size");}
		return data[index];
	}
	
	/**
	 * <p>������������޸������е�Ԫ��</p>
	 * @param index
	 * @param e
	 */
	public void set(int index, int e) {
		data[index] = e;
	}
	
	/**
	 * <p>����������ֲ����������Ƿ��и�Ԫ��,���ڷ���true�������ڷ���false</p>
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
	 * <p>����������ֲ����������Ƿ��и�Ԫ�أ��������������������򷵻�-1</p>
	 * @return
	 */
	public int find(int e) {
		for(int i = 0; i < size; i++) {
			if(data[i] == e) {return i;}
		}
		return -1;
	}
	
	/**
	 * <p>����������ɾ��Ԫ�أ�ɾ���󷵻�ɾ��Ԫ��</p>
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
	 * <p>ɾ����һ��Ԫ�أ�������ɾ��Ԫ��</p>
	 * @return
	 */
	public int removeFirst() {return remove(0);}
	
	/**
	 * <p>ɾ�����һ��Ԫ�أ�������ɾ��Ԫ��</p>
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
