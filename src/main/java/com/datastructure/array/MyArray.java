package com.datastructure.array;

import java.util.concurrent.TimeUnit;

/**
 * 
 *<p>Title:数据结构-数组部分<p>	
 *<p>Description:数组部分相关测试<p>	
 * @author Administrator
 * @version 2020-10-11
 *
 */
public class MyArray {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyNewArray array = new MyNewArray(20);
		
		for(int i = 0; i < 5; i++) {
			array.addLast(i);
		}
		
		System.out.println(array);
		array.addFirst(10);
		System.out.println(array);
		array.addLast(20);
		System.out.println(array);
		array.addIndex(3, 30);
		System.out.println(array);
		System.out.println(array.get(3));
		System.out.println("=====================");
		System.out.println(array.contains(30));
		System.out.println(array.find(30));
		System.out.println("=====================");
		System.out.println(array.removeFirst());
		System.out.println(array);
		System.out.println(array.removeLast());
		System.out.println(array);
		System.out.println(array.remove(2));
		System.out.println(array);
		
		System.out.println("----------------------------------------------------------------");
		Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		
		MyNewGenerics<Integer> array1 = new MyNewGenerics<>(20);

		for(int i = 0; i < 5; i++) {
			array1.addLast(i);
		}

		System.out.println(array1);
		array1.addFirst(10);
		System.out.println(array1);
		array1.addLast(20);
		System.out.println(array1);
		array1.addIndex(3, 30);
		System.out.println(array1);
		System.out.println(array1.get(3));
		System.out.println("=====================");
		System.out.println(array1.contains(30));
		System.out.println(array1.find(30));
		System.out.println("=====================");
		System.out.println(array1.removeFirst());
		System.out.println(array1);
		System.out.println(array1.removeLast());
		System.out.println(array1);
		System.out.println(array1.remove(2));
		System.out.println(array1);
		
		System.out.println("-----------------------测试动态泛型-----------------------------------------");
		MyNewGenerics<Integer> myNewGenerics = new MyNewGenerics<Integer>(5);
		for(int i = 0; i < 5; i++) {myNewGenerics.addLast(i);}
		System.out.println(myNewGenerics);
		myNewGenerics.addIndex(2, 20);
		System.out.println(myNewGenerics);
		myNewGenerics.remove(5);
		System.out.println(myNewGenerics);
		
		
	}

}
