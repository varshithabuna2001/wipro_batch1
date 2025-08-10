package com.wipro.sqldata;
import java.sql.*;
public class JDBC1 
{
public static void main(String[] args)throws Exception 
{
	Class.forName("com.mysql.cj.jdbc.Driver");//load driver
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","Varshitha@2001");
	
	Statement st=con.createStatement();

	
	st.execute("insert into student values(102,'pavithra','bangalore')");
	st.execute("insert into student values(104,'Akshay','bangalore')");

	System.out.println("row inserted");
}
}