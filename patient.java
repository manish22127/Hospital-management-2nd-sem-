package gp3;

import java.sql.*;
import java.util.Scanner;
public class patient {
	Scanner s = new Scanner(System.in);
	public String p_name,DOB,gender;
	
	public void add_patient()
	{
		System.out.println("enter the patient name ");
		p_name=s.next();
		System.out.println("enter the patient DOB in yy-mm-dd format only");
		DOB=s.next();
		System.out.println("enter the patient gender ");
		gender=s.next();
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			
			Statement st = con.createStatement();
			String qry = "insert into patient values('"+p_name+"','"+DOB+"','"+gender+"');";
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
			String qry = "delete from patient where name='"+temp+"';";
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
	
	public void display()
	{
		Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from patient;");
				System.out.println("Displaying table data...");
				while(rs.next()) {
					System.out.println("PATIENT NAME: "+rs.getString(1));
					System.out.println("DOB: "+rs.getDate(2));
					System.out.println("GENDER: "+rs.getString(3));
					System.out.println("******************************");
					con.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		patient p = new patient();
		int i=1;
		System.out.println("WELCOME TO PATIENT PORTAL");
		
		while(i!=0) {
		System.out.println("1.ADD PATIENT \n2.REMOVE PATIENT \n3.Display \n4.EXIT FROM PATIENT MODULE");
		int ch = s.nextInt();
		switch(ch) {
		case 1:
			p.add_patient();
			break;
		case 2:
			p.remove_patient();
			break;
		case 3:
			p.display();
			break;
		case 4:
			System.out.println("THANKYOU");
			i=0;
			break;
		default:
			System.out.println("enter valid details \n");

		}}
		
	}
}

