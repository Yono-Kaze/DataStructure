package com.datastructure.array;

/**
 * 
 *<p>Title:�Զ��巺��<p>	
 *<p>Description:���Զ�������ͨ��������֧��������������<p>	
 * @author Administrator
 * @version 2020-10-11
 *
 */
public class MyNewGenerics<E> {
	private E[] data;
	private int size;//�����е�ǰԪ������
	
	/**
	 * 
	 * <p>Description:����һ��Ĭ�ϵķ��ʹ�С10<p>
	 */
	public MyNewGenerics() {
		this(10);
	}
	
	/**
	 * 
	 * <p>Description:�û�����ķ��ʹ�Сcapacity<p>
	 * @param capacity
	 */
	public MyNewGenerics(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * <p>Description:���ط����е�ǰԪ�ظ���<p>
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * <p>Description:���ط��͵�����<p>
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
	public void addLast(E e) {
		addIndex(size,e);
	}
	
	/**
	 * <p>������Ԫ��ǰ���һ����Ԫ��<p>
	 * @param e
	 */
	public void addFirst(E e) {
		addIndex(0,e);
	}
	
	/**
	 * <p>���û���������������Ԫ��</p>
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
	 * <p>������������õ������е�Ԫ��</p>
	 * @param index
	 * @return data[index]
	 */
	public E get(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("get failed,index < 0 || index > size");}
		return data[index];
	}
	
	/**
	 * <p>������������޸ķ����е�Ԫ��</p>
	 * @param index
	 * @param e
	 */
	public void set(int index, E e) {
		data[index] = e;
	}
	
	/**
	 * <p>����������ֲ��ҷ������Ƿ��и�Ԫ��,���ڷ���true�������ڷ���false</p>
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
	 * <p>����������ֲ��ҷ������Ƿ��и�Ԫ�أ��������������������򷵻�-1</p>
	 * @return
	 */
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e)) {return i;}
		}
		return -1;
	}
	
	/**
	 * <p>����������ɾ��Ԫ�أ�ɾ���󷵻�ɾ��Ԫ��</p>
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
	 * <p>ɾ����һ��Ԫ�أ�������ɾ��Ԫ��</p>
	 * @return
	 */
	public E removeFirst() {return remove(0);}
	
	/**
	 * <p>ɾ�����һ��Ԫ�أ�������ɾ��Ԫ��</p>
	 * @return
	 */
	public E removeLast() {return remove(size - 1);}
	
	/**
	 * <p>���������������޸�</p>
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
