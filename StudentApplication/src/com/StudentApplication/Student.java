package com.StudentApplication;

public class Student {
      	private int id;
      	private String name;
      	private long phonenumber;
      	private int age;
      	
      	public Student() {
      		
      	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", age=" + age + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getPhoneNumber() {
			return phonenumber;
		}
		public void setPhoneNumber(long phonenumber) {
			this.phonenumber = phonenumber;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
}
