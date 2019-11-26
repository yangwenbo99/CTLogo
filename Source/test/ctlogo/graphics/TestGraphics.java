package ctlogo.graphics;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.Scanner;

import org.junit.Test;

import ctlogo.graphic.CTCanvas;
import ctlogo.graphic.Screen;
import ctlogo.graphic.VectorLine;
import ctlogo.graphic.VectorScreen;
import ctlogo.graphic.VectorShape;

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
		s.drawLine(1, 2, 100, 200);

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		s.drawLine(10, 20, 100, 200);

		String name2 = sc.nextLine();


	}

}
