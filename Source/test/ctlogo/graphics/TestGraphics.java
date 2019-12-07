package ctlogo.graphics;

import org.junit.Test;

import ctlogo.graphic.Screen;
import ctlogo.graphic.VectorScreen;

public class TestGraphics {

	@Test
	public void testCanvas() {

		Screen s = new VectorScreen();
//		Scanner sc = new Scanner(System.in);

		s.drawRectangle(1, 2, 100, 150);
//		sc.nextLine();		

		s.drawEclipse(0, 0, 100, 150);
//		sc.nextLine();		

		s.drawLine(1, 2, 100, 200);
		// sc.nextLine();

		s.setStroke(3);
		// sc.nextLine();

		s.drawLine(-50, -20, 100, -200);
		// sc.nextLine();

		s.setColor("red");
		// sc.nextLine();

		s.drawLine(-100, -20, 100, -200);
		// sc.nextLine();

		s.setColor("green");
		// sc.nextLine();

		s.drawLine(1, -20, 100, -200);
		// sc.nextLine();

		s.setColor("rd");
		// sc.nextLine();

		s.drawLine(-30, -20, 100, -200);
		// sc.nextLine();

		s.setWidth(500);
		// sc.nextLine();

		s.setHeight(400);
		// sc.nextLine();

		s.clean();
		// sc.nextLine();

		s.drawLine(1, 2, 100, 200);
		// sc.nextLine();

		s.drawLine(50, 20, 100, 200);
		s.drawRectangle(10, 10, 40, 40);
		s.drawEclipse(10, 10, 40, 40);
		// sc.nextLine();

		s.setHeight(500);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// sc.nextLine();

		s.clean();
		// sc.nextLine();

		// sc.close();
	}

}
