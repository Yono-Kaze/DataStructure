package com.datastructure.stackandqueue;

import com.datastructure.stackandqueue.impl.MyArrayLoopQueue;

/**
 * 
 *<p>Title:循环队列<p>	
 *<p>Description:循环队列相关测试<p>	
 * @author Administrator
 * @version 2020-10-14
 *
 */
public class MyLoopQueue {
	
	public static void main(String[] args) {
		
		MyArrayLoopQueue<Integer> queue = new MyArrayLoopQueue<Integer>();
		for(int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 16; i++) {
			if(i % 2 == 0) {
				queue.dequeue();
			}
			System.out.println(queue);
		}
	}

}
