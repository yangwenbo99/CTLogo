package ctlogo;

import java.io.FileNotFoundException;
import java.util.IllegalFormatException;
import java.util.Scanner;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTString;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.turtle.Turtle;
import ctlogo.turtle.TurtleManager;

public class Controller {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 1; i++) {
			System.out.println("Please input data: ");
			String inputData = "";
//			inputData = sc.nextLine();
			String outputData = "";
			// Testing area
//			TurtleManager tm = TurtleManager.getInstance();
//			tm.newTurtle(new Turtle());
//			System.out.println(tm.getTurtleByIndex(0).getX());			
			try {
				CTValue bool1 = new CTBoolean(true);
				CTValue undefined1 = new CTUndefined();
				CTValue string1 = new CTString("2");
				CTValue int1 = new CTInteger(2);
				CTValue double1 = new CTDouble(2.2);

				System.out.println("bool1 " + bool1);
				System.out.println("undefined1 " + undefined1);
				System.out.println("string1 " + string1);
				System.out.println("int1 " + int1);
				System.out.println("double1 " + double1);

				System.out.println("string1.convertTo(\"boolean\") " + string1.convertTo("boolean"));
//				System.out.println("string1.convertTo(\"integer\") "+string1.convertTo("integer"));
				System.out.println("string1.convertTo(\"double\") " + string1.convertTo("double"));
//				System.out.println("string1.convertTo(\"undefined\") "+string1.convertTo("undefined"));
				System.out.println("double1.convertTo(\"boolean\") " + double1.convertTo("boolean"));

				System.out.println("Start");
				System.out.println("string1.negate() " + string1.negate());

//				System.out.println(double1.compareTo(string1));
//				System.out.println(double1.compareTo(double1));
//				System.out.println(double1.compareTo(bool1));
//				System.out.println(string1.compareTo(double1));
//				System.out.println(double1.compareTo(double1));
//				System.out.println(bool1.compareTo(double1));

//				System.out.println(bool1.equals(undefined1));
//				System.out.println(bool1.compareTo(undefined1));
//				System.out.println(undefined1.equals(bool1));
//				System.out.println(undefined1.compareTo(bool1));
//				
//				System.out.println(bool1.equals(string1));
//				System.out.println(bool1.compareTo(string1));
//				System.out.println(string1.equals(bool1));
//				System.out.println(string1.compareTo(bool1));
//				
//				System.out.println(bool1.equals(int1));
//				System.out.println(bool1.compareTo(int1));
//				
//				System.out.println(bool1.equals(double1));
//				System.out.println(bool1.compareTo(double1));
//				
//				System.out.println(bool1.equals(undefined1));
//				System.out.println(bool1.compareTo(undefined1));
//				
//				System.out.println(bool1.equals(undefined1));
//				System.out.println(bool1.compareTo(undefined1));				

//				System.out.println(bool1.convertTo("string")+"2");	
//				System.out.println(bool1.convertTo("string")+"2");	

			} catch (Exception e) {
				e.printStackTrace();
			}
//			// End of testing area
			System.out.println("input: " + inputData);
			System.out.println("output: " + outputData);
		}

	}

}
