package gp3;
import java.sql.*;
import java.util.Scanner;

public class referal {
	Scanner s = new Scanner(System.in);
	public void add_referal() {
		String name,date,priority,s_name,apt_date;
		System.out.println("Enter The Patient Name");
		name = s.next();
		System.out.println("Enter The Date in yy-mm-dd format only");
		date=s.next();
		System.out.println("Enter The Priority");
		priority=s.next();
		System.out.println("Enter The Surgeon name");
		s_name=s.next();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
		
			Statement st = con.createStatement();
			String qry = "insert into referal(p_name,date,priority,surgeon) values('"+name+"','"+date+"','"+priority+"','"+s_name+"');";
			st.execute(qry);
			System.out.println("*********************************");
			System.out.println("Record inserted...");
			System.out.println("*********************************");
			con.close();
		}
		catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation dob) {
			System.out.println("please enter the date in YY-MM-DD foramt only");
			add_referal();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void remove_referal() {
		String name;
		System.out.println("Enter The Patient Name to remove referal");
		name = s.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			
			String query1 = "update referal set surgeon = ? where p_name = ?;";
			PreparedStatement st1 = con.prepareStatement(query1);
			st1.setString(1,null);
		    st1.setString(2,name);
		    st1.executeUpdate();
		  
			System.out.println("*********************************");
			System.out.println("Record updated...");
			System.out.println("*********************************");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update_appointment() {
		String name,date;
		System.out.println("Enter The Patient Name to update appointment date");
		name = s.next();
		System.out.println("enter the date");
		date=s.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			
			String query1 = "update referal set apt_date = ? where p_name = ?;";
			PreparedStatement st1 = con.prepareStatement(query1);
			st1.setString(1,date);
		    st1.setString(2,name);
		    st1.executeUpdate();
		  
			System.out.println("*********************************");
			System.out.println("Record updated...");
			System.out.println("*********************************");
			con.close();
		}
		catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation dob) {
			System.out.println("please enter the date in YY-MM-DD foramt only");
			update_appointment();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	referal r1 = new referal();
	
	System.out.println("WELCOME TO REFFERAL PORTAL");
	int i=1;
	while(i!=0) {
		System.out.println("1.ADD REFERRAL \n2.REMOVE REFERRAL \n3.UPDATE REFERRAL \n4.EXIT FROM REFERRAL MODULE");
		int ch = s.nextInt();
		switch(ch) {
		case 1:
			r1.add_referal();
			break;
		case 2:
			r1.remove_referal();
			break;
		case 3:
			r1.update_appointment();
			break;
		case 4:
			System.out.println("THANKYOU");
			i=0;
			break;
		default:
			System.out.println("enter valid details \n");
			}
		}


}}
