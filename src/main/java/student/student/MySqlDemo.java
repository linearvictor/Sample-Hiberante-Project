package student.student;

import java.sql.*;

import java.io.*;

public class MySqlDemo {

	public static void main(String[] args)
	{
	try
	{
		
//		creating connection
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
	
	/*
	Simple Statement
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from student");
	
	
	Create a query 
	String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200)  not null , tCity varchar(400))";
	
	create  a statement
	Statement stmt=con.createStatement();
	stmt.executeUpdate(q);
	System.out.println("table created in database..."); 
	
//	create a query
	String q = "insert into table1(tName,tCity) values(?,?)";
	
//	Get the Prepare Statement object
	PreparedStatement pstmt = con.prepareStatement(q);
	
//	taking data from user
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter Name : ");
	String name=br.readLine();
	
	System.out.println("Enter City : ");
	String city = br.readLine();
	
	pstmt.setString(1,name);
	pstmt.setString(2, city);
	
	pstmt.executeUpdate();
	System.out.println("inserted..."); */
	
	String q = "insert into images(pic) values(?)";
	
	PreparedStatement pstmt= con.prepareStatement(q);
	
//	inserting images in db
	FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Desktop/bed.jpg");
	pstmt.setBinaryStream(1,fis, fis.available());
	pstmt.executeUpdate();
	
	System.out.println("Done...");
	

//	ResultSet rs = st.executeQuery("select * from person");	
//	System.out.println( "Records Inserted :::" + rs);
//	while(rs.next())
//	{
//	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
//	System.out.println("JDBC connection successful");
//	}
//	rs.close();
	con.close();
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	}

}
