package com.datastructure.heapandpriorityqueue;

import java.util.Random;

import com.datastructure.array.MyNewGenerics;

/**
 * 
 *<p>Description:最大堆(使用数组实现)<p>	
 * @author Administrator
 * @version 2020-11-11
 *
 */
public class MaxHeap<E extends Comparable<E>> {

	private MyNewGenerics<E> data;

	public MaxHeap(int capacity){
		data = new MyNewGenerics<>(capacity);
	}

	public MaxHeap() {
		data = new MyNewGenerics<>();
	}
	
	/**
	 * 将数组初始化为堆
	 * @param arr
	 */
	public MaxHeap(E[] arr) {
		
		data = new MyNewGenerics<>(arr);
		for (int i = parent(arr.length - 1); i >= 0; i--) {
			siftDown(i);
		}
	}

	/**
	 * 返回堆中元素个数
	 * @return
	 */
	public int size() {
		return data.getSize();
	}

	/**
	 * 判断堆是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
	 * @param index
	 * @return
	 */
	private int parent(int index) {
		if(index == 0) {
			throw new IllegalArgumentException("index-0 doesn't have parent");
		}

		return (index - 1) / 2;
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	 * @param index
	 * @return
	 */
	private int leftChild(int index) {
		return index * 2 + 1;
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	 * @param index
	 * @return
	 */
	private int rightChild(int index) {
		return index * 2 + 2;
	}

	/**
	 * 向堆中添加元素
	 * @param e
	 */
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}

	/**
	 * 调整元素顺序
	 * @param k
	 */
	private void siftUp(int k) {
		while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
			data.swap(k, parent(k));
			k = parent(k);
		}
	}

	/**
	 *看堆中的最大元素
	 * @return
	 */
	public E findMax() {
		if(data.getSize() == 0) {
			throw new IllegalArgumentException("Can not findMax heap is empty");
		}
		return data.get(0);
	}

	/**
	 * 取出堆中最大元素
	 * @return
	 */
	public E extractMax() {

		E ret = findMax();

		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);

		return ret;
	}

	private void siftDown(int k) {
		while (leftChild(k) < data.getSize()) {
			int j = leftChild(k);
			if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0 ) {
				j = rightChild(k);
				//data[j] 是 leftChild 和 rightChild中的最大值
			}

			if(data.get(k).compareTo(data.get(j)) >= 0) { break;}
			data.swap(k, j);
			k = j;
		}

	}
	
	/**
	 * 取出堆中最大元素，并且替换成e
	 * @param e
	 * @return
	 */
	public E replace(E e) {
		
		E ret = findMax();
		data.set(0, e);
		siftDown(0);
		return ret;
	}
	
	private static double testHeap(Integer[] testData, boolean isHeapify) {
		long startTime = System.currentTimeMillis();
		MaxHeap<Integer> maxHeap;
		
		if (isHeapify) {
			maxHeap = new MaxHeap<Integer>(testData);
		}else {
			maxHeap = new MaxHeap<Integer>();
			for (Integer num : testData) {
				maxHeap.add(num);
			}
		}
		
		int[] arr = new int[testData.length];
		for (int i = 0; i < testData.length; i++) {
			arr[i] = maxHeap.extractMax();
		}

		for (int i = 1; i < testData.length; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}

		System.out.println("Test MaxHeap completed");
		
		long endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 100000;

		System.out.println("==============================Test1=================");
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = maxHeap.extractMax();
		}

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}

		System.out.println("Test MaxHeap completed");
		System.out.println("==============================Test2=================");
		
		Integer[] testData = new Integer[n];
		for (int i = 0; i < n; i++) {
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		}
		
		double time1 = testHeap(testData, false);
		System.out.println("Without heapify" + time1);
		
		double time2 = testHeap(testData, true);
		System.out.println("With heapify" + time2);
	}

}
