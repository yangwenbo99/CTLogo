package ctlogo.execute;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.graphic.Screen;
import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import java.io.PrintStream;
import java.util.Scanner;

// This will test AbstractContext, GlobalContext and LocalContext
public class TestContext {

	private final Scanner sc = new Scanner("Test scanner");
	private final PrintStream os = System.out;
	private final VariableManager vm = new GlobalVariableManager();
	private final Screen sn = StubScreen.theInstance;
	
	private static class StubContext extends AbstractContext {
		public StubContext(Context enclosingContext) {
			super(null, null, null, null, enclosingContext);
		}
	}

	private final GlobalContext gbl = new GlobalContext(
			sc, 
			os,
			sn,
			vm);
	private final LocalContext lcl = new LocalContext(gbl);
	
	@Test
	void testConstructAbstractContext() {
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() -> new StubContext(null));
	}
	
	@Test 
	void testConstructLocalContext() {
		vm.setLocalVariable("Test", cint(1));
		Context lcl1 = new LocalContext(gbl);
		Context lcl2 = new LocalContext(null, null, null, null, gbl);
		Assertions.assertEquals(
				cint(1),
				lcl1.getValueOf("Test"));
		Assertions.assertEquals(
				cint(1),
				lcl2.getValueOf("Test"));
	}
	
	@Test 
	void testGetInputScanner() {
		// held by self
		Assertions.assertSame(sc, gbl.getInputScanner());
		// Inherented
		Assertions.assertSame(sc, lcl.getInputScanner());
	}
	
	@Test
	void testGetOutputStream() {
		Assertions.assertSame(os, gbl.getOutputStream());
		Assertions.assertSame(os, lcl.getOutputStream());
	}
	
	@Test
	void testGetScreen() {
		Assertions.assertSame(sn, gbl.getScreen());
		Assertions.assertSame(sn, lcl.getScreen());
	}
	
	@Test
	void testGetVariableManager() {
		Assertions.assertSame(vm, gbl.getVariableManager());
		Context sctx = new StubContext(gbl);
		Assertions.assertSame(vm, sctx.getVariableManager());
	}
	
	@Test
	void testGetValueOf() {
		vm.setVariable("Test", cint(-1));
		Assertions.assertEquals(
				cint(-1), gbl.getValueOf("test"));
	}
	
	

}