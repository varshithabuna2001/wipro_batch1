package com.wipro.anonymous;

public class employe {
                String empname;
				int empage;
				 double empsalary;
				
				public employe(String empname, int empage,double empsalary)
				{
				this.empname = empname;
				this.empage = empage;
				this.empsalary = empsalary;
				}
				 public String toString() {
					 return "empname:"+empname+"  empage"+empage+"  empsalary"+empsalary;				 }

}
