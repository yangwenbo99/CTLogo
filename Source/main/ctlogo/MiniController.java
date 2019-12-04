package ctlogo;

import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.AbstractContext;
import ctlogo.execute.BasicExpressionStream;
import ctlogo.execute.Context;
import ctlogo.execute.ExpressionStream;
import ctlogo.execute.expression.Expression;
import ctlogo.graphic.Screen;
import ctlogo.graphic.VectorScreen;
import ctlogo.processing.BasicTokenStream;
import ctlogo.processing.TokenStream;

public class MiniController {

	public static void main(String[] args) {

		/*
		 * Try the following input, they should not trigger any error. 1 1 1 1 + 2 1 +
		 * (2 * 3) 1 + (+2 * 3) (-2 * 5) + 2 PR 1 + 2 PR 32 + 34 PR 32 + 34 6 (PR 1 + 2
		 * 4) * 7
		 */

		class StubContext extends AbstractContext {
			public StubContext(Scanner scanner, PrintStream outputStream, Screen screen,
					VariableManager variableManager) {
				super(scanner, outputStream, screen, variableManager);
			}
		}
		
//		class StubScreen implements Screen {
//
//			@Override
//			public void drawLine(double x1, double y1, double x2, double y2) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void drawRectangle(double x1, double y1, double x2, double y2) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void drawEclipse(double cx, double cy, double a, double b) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void clean() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void setWidth(double w) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void setHeight(double h) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void setStroke(double s) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void setColor(String color) {
//				// TODO Auto-generated method stub
//				
//			}
//		}

		Context stubContext = new StubContext(
				new Scanner("Test scanner"), 
				System.out, 
				new VectorScreen(), 
				new GlobalVariableManager());

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print(">>> ");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				while (line.length() > 0 && line.charAt(line.length() - 1) == '_') {
					line += sc.nextLine();
				}
				TokenStream ts = new BasicTokenStream(new Scanner(line));
				ExpressionStream es = new BasicExpressionStream(ts);

				try {
					while (true) {
						Expression exp = es.getNextExpression();
						exp.execute(stubContext);
					}
				} catch (NoSuchElementException e) {
					// End of line
					System.out.println();
				} catch (CTSyntaxException e) {
					System.out.printf("Error %s, at line %d: %s\n",
							e.getClass().toString(),
							ts.getCurrentRow(),
							e.getMessage());
				} catch (CTException e) {
					System.out.printf("Error %s, at line %d: %s\n",
							e.getClass().toString(),
							ts.getCurrentRow(),
							e.getMessage());
				}

				System.out.print(">>> ");
			}
		}
	}
}
