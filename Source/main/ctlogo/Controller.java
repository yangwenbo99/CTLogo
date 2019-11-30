package ctlogo;

import java.util.Scanner;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTString;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;

public class Controller {
	public static void main(String args[]) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			for (int i = 0; i < 1; i++) {
				System.out.println("Please input data: ");
				String inputData = "";
	//			inputData = sc.nextLine();
				String outputData = "";
				try {
					CTValue bool1 = new CTBoolean(true);
					CTValue undefined1 = new CTUndefined();
					CTValue string1 = new CTString("-2.3a");
					CTValue string2 = new CTString("-0.3b");
					CTValue string3 = new CTString("0.0");
					CTValue string4 = new CTString("+1.3");
					CTValue int1 = new CTInteger(-2);
					CTValue int2 = new CTInteger(-1);
					CTValue int3 = new CTInteger(0);
					CTValue int4 = new CTInteger(1);
					CTValue double1 = new CTDouble(2.3);
					CTValue double2 = new CTDouble(1.3);
					CTValue double3 = new CTDouble(0.0);
					CTValue double4 = new CTDouble(-1.2);

					System.out.println("bool1 " + bool1);
					System.out.println("undefined1 " + undefined1);
					System.out.println("string1 " + string1);
					System.out.println("string2 " + string2);
					System.out.println("string3 " + string3);
					System.out.println("string4 " + string4);
					System.out.println("int1 " + int1);
					System.out.println("int2 " + int2);
					System.out.println("int3 " + int3);
					System.out.println("int4 " + int4);
					System.out.println("double1 " + double1);
					System.out.println("double2 " + double2);
					System.out.println("double3 " + double3);
					System.out.println("double4 " + double4);

					System.out.println("Start");
					
	//				System.out.println("double1.add(double2) " + (double1.add(double2)));
					
	//				System.out.println("double1.add(string2) " + (double1.add(string2)));
	//				System.out.println("string2.add(double1) " + (string2.add(double1)));
	//				System.out.println("double1.subtract(string2) " + (double1.subtract(string2)));	
	//				System.out.println("string2.subtract(double1) " + (string2.subtract(double1)));	
	//				
					System.out.println("int1.add(string2) " + (int1.add(string2)));
					System.out.println("string2.add(int1) " + (string2.add(int1)));
					System.out.println("int1.subtract(string2) " + (int1.subtract(string2)));	
					System.out.println("string2.subtract(int1) " + (string2.subtract(int1)));	

					System.out.println("End");				

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("input: " + inputData);
				System.out.println("output: " + outputData);
			}
		}

	}

}
