package gp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class doctor {
	Scanner s = new Scanner(System.in);
	public String d_name,speaciality;
	
	public void add_doctor()
	{
		System.out.println("enter the DOCTOR name ");
		d_name=s.next();
		System.out.println("enter the Doctor Speaciality");
		speaciality=s.next();
		
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			
			Statement st = con.createStatement();
			String qry = "insert into doctor values('"+d_name+"','"+speaciality+"');";
			st.execute(qry);
			System.out.println("*********************************");
			System.out.println("Record inserted...");
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
				ResultSet rs = st.executeQuery("select * from doctor;");
				System.out.println("Displaying table data...");
				while(rs.next()) {
					System.out.println("DOCTOR NAME: "+rs.getString(1));
					System.out.println("SPECIALITY: "+rs.getString(2));
					System.out.println("******************************");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void remove_doctor() {
		String temp;
		System.out.println("enter the doctor name to delete");
		temp=s.next();
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_group3","manish","Manish@123");
			System.out.println("Connection created...");
			
			Statement st = con.createStatement();
			String qry = "delete from doctor where name='"+temp+"';";
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
	
	
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			doctor d = new doctor();
			int i=1;
			System.out.println("WELCOME TO DOCTOR PORTAL");
			
			while(i!=0) {
			System.out.println("1.ADD DOCTOR \n2.REMOVE DOCTOR \n3.DISPLAY DOCTORS \n4.EXIT FROM DOCTOR MODULE");
			int ch = s.nextInt();
			switch(ch) {
			case 1:
				d.add_doctor();
				break;
			case 2:
				d.remove_doctor();
				break;
			case 3:
				d.display();
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
