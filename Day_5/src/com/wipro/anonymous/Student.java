package com.wipro.anonymous;

public class Student {
private int rollno;
private String name;
private String address;
		public Student(int rollno, String name, String address) {
			super();
			this.rollno = rollno;
			this.name = name;
			this.address = address;
		}
		@Override
		public String toString() {
			return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";
		}

		}

