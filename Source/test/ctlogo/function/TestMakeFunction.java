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
import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.AbstractContext;
import ctlogo.execute.Context;
import ctlogo.execute.DummpExpression;
import ctlogo.execute.StubScreen;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;
import ctlogo.graphic.Screen;
import ctlogo.function.PrintFunction;

import static ctlogo.data.TestDataUtility.*;

public class TestMakeFunction {
    
    private final Scanner sc = new Scanner("Test scanner");
    private final PrintStream os = System.out;
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
    
    TestMakeFunction() {
        baoStream = new ByteArrayOutputStream();
        ptStream  = new PrintStream(baoStream);
        stubContext = new StubContext(sc, ptStream, sn, vm);
    }

    Expression pr(List<Expression> input) throws CTException {
        PrintFunction pf  = PrintFunction.getInstance();
        Expression    pfe = pf.getFunctionExpression(input);
        return pfe;
    }

    Expression make(List<Expression> input) throws CTException {
        MakeFunction mkf = MakeFunction.getInstance();
        return mkf.getFunctionExpression(input);

    }
    
    private static String getContent(ByteArrayOutputStream baos) {
        return baos.toString().replace("\r\n", "\n");
    }
    
    @Test
    void test1() throws CTException {
        Assertions.assertEquals(
                cint(1),
                make(List.<Expression>of(
                        w(cstr("A")), 
                        w(cint(1)))).execute(stubContext));
        // vm.setVariable("A", cint(1));
        Assertions.assertEquals(
                cint(1),
                vm.getValue("A"));
        Assertions.assertEquals(
                cint(2),
                make(List.<Expression>of(
                        w(cstr("A")), 
                        w(cint(2)))).execute(stubContext));
        Assertions.assertEquals(
                cint(2),
                vm.getValue("A"));
    }
    
}
