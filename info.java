package gp3;

import java.util.Scanner;

public class info {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			
			int i=0;
			while (i==0){
			System.out.println("1.Patients \n2.Surgical Waiting list \n3.Add Diagnostic Test \n4.Add Referal \n 5.Surgeon\n");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
			{
				System.out.println("Entering Patients Module");
				patient.main(null);
			}
			case 2:
			{
				System.out.println("Entering Surgicals Module");
			}
			case 3:
			{
				System.out.println("Entering Diagnostic test Module");
			}
			case 4:
			{
				System.out.println("Entering Referral Module");
			}
			case 5:
			{
				System.out.println("Entering Doctor Module");
				doctor.main(null);
			}
			case 6:
			{
				System.out.println("Exitting.....");
				i=1;
			}
			default:
			{
				System.out.println("Please enter proper data");
			}
			}
			
			
			
			}
			
		}
}
