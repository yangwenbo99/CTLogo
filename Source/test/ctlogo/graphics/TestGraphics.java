package ctlogo.graphics;

import java.util.Scanner;

import org.junit.Test;

import ctlogo.graphic.Screen;
import ctlogo.graphic.VectorScreen;

public class TestGraphics {

	@Test
	public void testCanvas() {

//	    CTCanvas ctc = new CTCanvas();
//		
//	    VectorShape vs = new VectorLine(3,3,45,45);
//		CTCanvas.addVectorShape(vs);		
//
//	    VectorShape vs2 = new VectorLine(3,100,45,45);
//		CTCanvas.addVectorShape(vs2);		
//
//		
//	    Scanner sc = new Scanner(System.in); 
//        String name = sc.nextLine(); 
//        
//	    VectorShape vs4 = new VectorLine(3,23,45,45);
//		CTCanvas.addVectorShape(vs4);		
//
//	    VectorShape vs5 = new VectorLine(3,63,45,45);
//		CTCanvas.addVectorShape(vs5);
//		
//	    CTCanvas ctc2 = new CTCanvas();
//
//        String name2 = sc.nextLine(); 

		Screen s = new VectorScreen();
		Scanner sc = new Scanner(System.in);

		s.drawLine(1, 2, 100, 200);
		sc.nextLine();		
		
		s.setStroke(3);
		sc.nextLine();

		s.drawLine(-50, -20, 100, -200);
		sc.nextLine();
		
		s.setColor("red");
		sc.nextLine();

		s.drawLine(-100, -20, 100, -200);
		sc.nextLine();
		
		s.setColor("green");
		sc.nextLine();

		s.drawLine(1, -20, 100, -200);
		sc.nextLine();

		s.setColor("rd");
		sc.nextLine();

		s.drawLine(-30, -20, 100, -200);
		sc.nextLine();

		s.setWidth(500);
		sc.nextLine();

		s.setHeight(400);
		sc.nextLine();		
		
		s.clean();
		sc.nextLine();

		s.drawLine(1, 2, 100, 200);
		sc.nextLine();
		
		s.drawLine(50, 20, 100, 200);
		sc.nextLine();		

		s.setHeight(300);
		sc.nextLine();		

		s.clean();
		sc.nextLine();

		sc.close();
	}

}
