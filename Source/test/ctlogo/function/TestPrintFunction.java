package ctlogo.function;

import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTValue;
import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.execute.AbstractContext;
import ctlogo.execute.Context;
import ctlogo.execute.StubScreen;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;
import ctlogo.graphic.Screen;

public class TestPrintFunction {
    
	private final Scanner sc = new Scanner("Test scanner");
	private final VariableManager vm = new GlobalVariableManager();
	private final Screen sn = StubScreen.theInstance;
	
    class StubContext extends AbstractContext {
        public StubContext(
                Scanner scanner, 
                PrintStream outputStream, 
                Screen screen, 
                VariableManager variableManager) {
            super(scanner, outputStream, screen, variableManager);
        }
    }

    private static Expression w(CTValue v) {
        return new LiteralExpression(v);
    }

    private PrintStream ptStream;    
    private ByteArrayOutputStream baoStream;
    private Context stubContext;
    
    TestPrintFunction() {
        baoStream = new ByteArrayOutputStream();
        ptStream  = new PrintStream(baoStream);
        stubContext = new StubContext(sc, ptStream, sn, vm);
    }

    CTValue executeTest(List<Expression> input) throws CTException {
        PrintFunction pf  = PrintFunction.getInstance();
        Expression    pfe = pf.getFunctionExpression(input);
        return pfe.execute(stubContext);
    }
    
    private static String getContent(ByteArrayOutputStream baos) {
    	return baos.toString().replace("\r\n", "\n");
    }
    
    @Test
    void test1() throws CTException {
        Assertions.assertEquals(
                cint(-1), executeTest(List.<Expression>of(w(cint(-1)))));
        Assertions.assertEquals("-1\n", getContent(baoStream));
    }
    
    @Test
    void test2() throws CTException {
        Assertions.assertEquals(
                cstr("String"), executeTest(List.<Expression>of(w(cint(1)), w(cstr("String")))));
        Assertions.assertEquals("1 String\n", getContent(baoStream));
    }
    
    @Test
    void testParamNum() throws CTException {
        Assertions.assertEquals(
        		1, 
        		PrintFunction.getInstance().getDefaultParameterNum());
    }
    
}
