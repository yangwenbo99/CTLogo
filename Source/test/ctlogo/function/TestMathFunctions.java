/**
 * 
 */
package ctlogo.function;

import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;

/**
 * @author Paul Yang
 *
 */
public class TestMathFunctions {
	
	private static LiteralExpression l(CTValue v) {
		return new LiteralExpression(v);
	}

	@Test
	void testSin() throws CTException {
		Assertions.assertEquals(
				cdbl(Math.sin(2)), 
				SinFunction.getInstance().execute(
						null, 
						List.<Expression>of(l(cint(2)))
						));
		Assertions.assertEquals(1, SinFunction.getInstance().getDefaultParameterNum());
	}

	@Test
	void testCos() throws CTException {
		Assertions.assertEquals(
				cdbl(Math.cos(2)), 
				CosFunction.getInstance().execute(
						null, 
						List.<Expression>of(l(cint(2)))
						));
		Assertions.assertEquals(1, CosFunction.getInstance().getDefaultParameterNum());
	}

	@Test
	void testTan() throws CTException {
		Assertions.assertEquals(
				cdbl(Math.tan(2)), 
				TanFunction.getInstance().execute(
						null, 
						List.<Expression>of(l(cint(2)))
						));
		Assertions.assertEquals(1, TanFunction.getInstance().getDefaultParameterNum());
	}

	@Test
	void testAsin() throws CTException {
		Assertions.assertEquals(
				cdbl(Math.asin(0.25)), 
				AsinFunction.getInstance().execute(
						null, 
						List.<Expression>of(l(cdbl(0.25)))
						));
		Assertions.assertEquals(1, AsinFunction.getInstance().getDefaultParameterNum());
	}

	@Test
	void testAcos() throws CTException {
		Assertions.assertEquals(
				cdbl(Math.acos(0.25)), 
				AcosFunction.getInstance().execute(
						null, 
						List.<Expression>of(l(cdbl(0.25)))
						));
		Assertions.assertEquals(1, AcosFunction.getInstance().getDefaultParameterNum());
	}

	@Test
	void testAtan() throws CTException {
		Assertions.assertEquals(
				cdbl(Math.atan(0.25)), 
				AtanFunction.getInstance().execute(
						null, 
						List.<Expression>of(l(cdbl(0.25)))
						));
		Assertions.assertEquals(1, AtanFunction.getInstance().getDefaultParameterNum());
	}

	@Test
	void testAtan2() throws CTException {
		Assertions.assertEquals(
				cdbl(Math.atan2(0.25, 1)), 
				Atan2Function.getInstance().execute(
						null, 
						List.<Expression>of(l(cdbl(0.25)), l(cdbl(1))))
						);
		Assertions.assertEquals(2, Atan2Function.getInstance().getDefaultParameterNum());
	}
}
