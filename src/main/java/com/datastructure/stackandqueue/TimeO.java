package com.datastructure.stackandqueue;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.datastructure.stackandqueue.impl.MyArrayLoopQueue;
import com.datastructure.stackandqueue.impl.MyArrayQueue;

/**
 * 
 *<p>Title:复杂度分析<p>	
 *<p>Description:队列和循环队列的时间对比<p>	
 * @author Administrator
 * @version 2020-10-14
 *
 */
public class TimeO {
	
	public static void main(String[] args) {
		
		int opConut = 100000;
		MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<Integer>();
		double time1 = testTime(myArrayQueue, opConut);
		System.out.println("ArrayQueue:" + time1);
		
		MyArrayLoopQueue<Integer> myArrayLoopQueue = new MyArrayLoopQueue<Integer>();
		double time2 = testTime(myArrayLoopQueue, opConut);
		System.out.println("myArrayLoopQueue:" + time2);
	}

	private static double testTime(InterfaceQueue<Integer> q, int opConut) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		for(int i = 0; i < opConut; i++) {
			q.enqueue(new Random().nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0; i < opConut; i++) {
			q.dequeue();
		}
		
		long end = System.currentTimeMillis();
		return TimeUnit.MILLISECONDS.toSeconds(end - start);
	}

}
