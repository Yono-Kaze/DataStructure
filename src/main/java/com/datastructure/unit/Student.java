package com.datastructure.unit;

/**
 * 
 *<p>Title:学生类<p>	
 *<p>Description:测试用学生类<p>	
 * @author Administrator
 * @version 2020-10-11
 *
 */
public class Student{
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
		res.append(String.format("Student id = %d, name = %s, ismale = %b", id, name,ismale));
		res.append(']' + "\n");
		return res.toString();
	}

}


