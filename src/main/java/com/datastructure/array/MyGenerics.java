package com.datastructure.array;

/**
 * 
 *<p>Title:���ݽṹ-���Ͳ���<p>	
 *<p>Description:���Ͳ�����ز���<p>	
 * @author Administrator
 * @version 2020-10-11
 *
 */
public class MyGenerics {
	
	/**
	 * 
	 *<p>Title:ѧ����<p>	
	 *<p>Description:����������id��name��ismale<p>	
	 * @author Administrator
	 * @version 2020-10-11
	 *
	 */
	static class Student{
		private int id;
		private String name;
		private boolean ismale;

		public Student(int id, String name, boolean ismale) {
			this.id = id;
			this.name = name;
			this.ismale = ismale;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean isIsmale() {
			return ismale;
		}
		public void setIsmale(boolean ismale) {
			this.ismale = ismale;
		}

		@Override
		public String toString() {
			StringBuffer res = new StringBuffer();
			res.append('[');
			res.append(String.format("Student id = %d, name = %s, ismale = %b ", id, name,ismale));
			res.append('[');
			res.append(id);
			res.append(',' + name + ',');
			res.append(ismale);
			res.append(']').append(']');
			return res.toString();
		}
		
	}
	
	public static void main(String[] args) {
		
		Student student = new Student(2, "20", true);
		System.out.println(student);
		
		MyNewGenerics<Student> student1 = new MyNewGenerics<Mygenerics.Student>();
		
		for(int i = 0; i < 6; i++) {
			student1.addLast(new Student(i, toString(i), (Math.random() < 0.5 ? true :false)));
		}
		System.out.println(student1);
		student1.addFirst(new Student(10, "qwe", false));
		System.out.println("---------------------------------------------");
		System.out.println(student1);
		System.out.println("---------------------------------------------");
		student1.removeLast();
		student1.remove(2);
		System.out.println(student1);
		
	}

	private static String toString(int i) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(i);
		return buffer.toString();
	}

}
