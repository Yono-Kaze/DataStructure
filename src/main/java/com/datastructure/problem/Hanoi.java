package com.datastructure.problem;

public class Hanoi {
	
	static int m = 0;
	
	public static void move(int i, char c1, char c2) {
		 System.out.println("第" + (++m) +" 次 : " + i +" 号圆盘从 " + c1 +" -->  " + c2);
	}

	public static void hanoit(int i, char A, char B, char C) {
		if(i == 1) {
			move(i, A, C);
		}else {
			hanoit(i - 1, A, C, B);
			move(i, A, C);
			hanoit(i - 1, B, A, C);		
		}
	}

	public static void main(String[] args) {
		hanoit(2, 'A', 'B', 'C');

	}


}
