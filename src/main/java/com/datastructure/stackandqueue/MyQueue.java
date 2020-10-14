package com.datastructure.stackandqueue;

import com.datastructure.stackandqueue.impl.MyArrayQueue;
import com.datastructure.unit.Student;

/**
 * 
 *<p>Title:数据结构-队列部分<p>	
 *<p>Description:队列的测试<p>	
 * @author Administrator
 * @version 2020-10-14
 *
 */
public class MyQueue {
	
	public static void main(String[] args) {
		
		MyArrayQueue<Integer> queue = new MyArrayQueue<Integer>();
		for(int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 5; i++) {
			if(i % 2 == 0) {
				queue.dequeue();
			}
			System.out.println(queue);
		}
	}

}
