package gp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class surgical extends patient{
	Scanner s = new Scanner(System.in);
	int i=1;
	
	public void add_patient() {
		String ps_name,type,s_name,priority,p_date,r_date;
		System.out.println("enter the patient name ");
		ps_name=s.next();
		System.out.println("enter the type of operation");
		type=s.next();
		System.out.println("enter the priority ");
		priority=s.next();
		System.out.println("enter the suregeon name ");
		s_name=s.next();
		System.out.println("enter the Placement date in yy-mm-dd format only");
		p_date=s.next();
		System.out.println("enter the removal date in yy-mm-dd format only");
		r_date=s.next();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			
			Statement st = con.createStatement();
			String qry = "insert into surgical values('"+ps_name+"','"+type+"','"+priority+"','"+s_name+"','"+p_date+"','"+r_date+"');";
			st.execute(qry);
			System.out.println("*********************************");
			System.out.println("Record inserted...");
			System.out.println("*********************************");
			con.close();
		}
		catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation dob) {
			System.out.println("please enter the date in YY-MM-DD foramt only");
			add_patient();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void remove_patient() {
		String temp;
		System.out.println("enter the patient name to delete");
		temp=s.next();
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			
			Statement st = con.createStatement();
			String qry = "delete from surgical where name='"+temp+"';";
			st.executeUpdate(qry);
			System.out.println("*********************************");
			System.out.println("Record deleted...");
			System.out.println("*********************************");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void display_waiting_list() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from surgical;");
			System.out.println("Displaying table data...");
			while(rs.next()) {
				System.out.println("PATIENT NAME: "+rs.getString(1));
				System.out.println("TYPE: "+rs.getString(2));
				System.out.println("PRIORITY: "+rs.getString(3));
				System.out.println("SURGEON NAME: "+rs.getString(4));
				System.out.println("PLACEMENT DATE: "+rs.getDate(5));
				System.out.println("REMOVAL DATE: "+rs.getDate(6));
				System.out.println("******************************");
				con.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

public static void main(String[] args) {
	surgical s1 = new surgical();
	Scanner s = new Scanner(System.in);
	int i=1;
	System.out.println("WELCOME TO SURGICAL PORTAL");
	
	while(i!=0) {
	System.out.println("1.ADD PATIENT \n2.REMOVE PATIENT \n3.Display \n4.EXIT FROM PATIENT MODULE");
	int ch = s.nextInt();
	switch(ch) {
	case 1:
		s1.add_patient();
		break;
	case 2:
		s1.remove_patient();
		break;
	case 3:
		s1.display_waiting_list();
		break;
	case 4:
		System.out.println("THANKYOU");
		i=0;
		break;
	default:
		System.out.println("enter valid details \n");

	}}
	
	
}}
