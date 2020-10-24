package com.datastructure.linkedlist;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.datastructure.stackandqueue.InterfaceQueue;
import com.datastructure.stackandqueue.InterfaceStack;
import com.datastructure.stackandqueue.impl.MyArrayLoopQueue;
import com.datastructure.stackandqueue.impl.MyArrayQueue;
import com.datastructure.stackandqueue.impl.MyArrayStack;

/**
 * 
 *<p>Description:时间复杂度比较：数组栈和链表栈的,数组队列和链表队列<p>	
 * @author Administrator
 * @version 2020-10-24
 *
 */
public class TimeOTest {
	
	public static void main(String[] args) {
		int opConut = 1000;
		MyArrayStack<Integer> myArrayStack = new MyArrayStack<Integer>();
		double time1 = testTime(myArrayStack, opConut);
		System.out.println("myArrayStack:" + time1);
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
		double time2 = testTime(linkedListStack, opConut);
		System.out.println("linkedListStack:" + time2);
		
		System.out.println("======================================================");	
		
		
		MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<Integer>();
		double time3 = testTime(myArrayQueue, opConut);
		System.out.println("myArrayQueue:" + time3);	
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
		double time4 = testTime(linkedListQueue, opConut);
		System.out.println("linkedListQueue:" + time4);
	}
	
	private static double testTime(InterfaceStack<Integer> q, int opConut) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		for(int i = 0; i < opConut; i++) {
			q.push(new Random().nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0; i < opConut; i++) {
			q.pop();
		}
		
		long end = System.currentTimeMillis();
		return end - start;
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
		return end - start;
	}

}
