package ctlogo;

import java.io.FileNotFoundException;
import java.util.IllegalFormatException;
import java.util.Scanner;

import ctlogo.data.CTBoolean;
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

			CTValue bool1=new CTUndefined();
			System.out.print(bool1);
			System.out.print(bool1.equals(bool1));			
			
			// End of testing area
			System.out.println("input: " + inputData);
			System.out.println("output: " + outputData);
		}

	}

}
