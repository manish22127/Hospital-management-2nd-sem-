package gp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class diagnostic {
	Scanner s = new Scanner(System.in);
	public void add_order() {
		String test,p_name,s_name,date_ordered;
		
		System.out.println("Enter The Test Name");
		test=s.next();
		System.out.println("Enter Patient Name");
		p_name=s.next();
		System.out.println("Enter Surgeon Name");
		s_name=s.next();
		System.out.println("Please enter the Order date in YY-MM-DD foramt only");
		date_ordered=s.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
		
			Statement st = con.createStatement();
			String qry = "insert into test(test,p_name,s_name,order_date) values('"+test+"','"+p_name+"','"+s_name+"','"+date_ordered+"');";
			st.execute(qry);
			System.out.println("*********************************");
			System.out.println("Record inserted...");
			System.out.println("*********************************");
			con.close();
		}
		catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation dob) {
			System.out.println("please enter the date in YY-MM-DD foramt only");
			add_order();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void add_result() {
		String result,date,p_name;
		System.out.println("Enter the patients Name who you want update result");
		p_name=s.next();
		System.out.println("Enter The Result");
		result=s.next();
		System.out.println("Enter The Result Date in yy-mm-dd formar only");
		date=s.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			String query = "update test set result = ? where p_name = ?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,result);
		    st.setString(2,p_name);
		    st.executeUpdate();
		    
		    
		    
		    String query1 = "update test set result_date = ? where p_name = ?;";
			PreparedStatement st1 = con.prepareStatement(query1);
			st1.setString(1,date);
		    st1.setString(2,p_name);
		    st1.executeUpdate();
		  
			System.out.println("*********************************");
			System.out.println("Record updated...");
			System.out.println("*********************************");
			con.close();
		}
		catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation dob) {
			System.out.println("please enter the date in YY-MM-DD foramt only");
			add_result();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

public static void main(String[] args) {
	diagnostic d1 = new diagnostic();
	//d1.add_order();
	d1.add_result();
}}