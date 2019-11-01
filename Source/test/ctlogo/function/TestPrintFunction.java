package ctlogo.function;

import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.*;

import ctlogo.data.CTInteger;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.AbstractContext;
import ctlogo.execute.Context;
import ctlogo.execute.DummpExpression;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;
import ctlogo.graphic.Screen;
import ctlogo.function.PrintFunction;

import static ctlogo.data.TestDataUtility.*;

public class TestPrintFunction {
    
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
        stubContext = new StubContext(null, ptStream, null, null);
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
                cstr("String"), executeTest(List.<Expression>of(w(cstr("String")))));
        Assertions.assertEquals("String\n", getContent(baoStream));
    }
    
}
