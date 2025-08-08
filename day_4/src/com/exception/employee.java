package com.exception;

public class employee {

	String empname;
			String empid;
			int empage;
			 static double empsalary;
			
			public employee(String empname, String empid, int empage,double empsalary)
			{
			this.empname = empname;
			this.empid = empid;
			this.empage = empage;
			this.empsalary = empsalary;
			}
		public String toString()
		{
		 return empid+ "-"+empname+"-"+empage+"-"+empsalary;
	}
			 public String getEmpname() {
				 return empname;
			 }
			 public void setEmpname(String empname) {
				 this.empname = empname;
			 }
			 public String getEmpid() {
				 return empid;
			 }
			 public void setEmpid(String empid) {
				 this.empid = empid;
			 }
			 public int getEmpage() {
				 return empage;
			 }
			 public void setEmpage(int empage) {
				 this.empage = empage;
			 }
			 public static double getEmpsalary() {
				 return empsalary;
			 }
			public void setEmpsalary(double empsalary) {
				 this.empsalary = empsalary;
			 }
			 
			 
	 
	}
	
	

