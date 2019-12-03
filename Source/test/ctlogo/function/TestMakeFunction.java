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

    Expression make(List<Expression> input) throws CTException {
        MakeFunction mkf = MakeFunction.getInstance();
        return mkf.getFunctionExpression(input);

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
    }
    
}
