package me.tattie.testjava;

public class RuntimeExceptionTest {

	public static void main(String[] args) {
		
		int n = 0;
		
		try {
			
			n = string2Int("xyz3");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Bad number format!");
		}
		
		System.out.print(n);
		
		// RuntimeExceptions are unchecked exceptions, don't need to catch or declare
		n = string2Int("3.14");
		
		// test Exception that are NOT RuntimeException
		try {
			throwCheckedException();
		} catch (MyException e) {
			
		}
	}
	
	public static int string2Int(final String s) {
		// maybe throw NumberFormatException, but it's a kind of RuntimeException,
		// so don't need to declare it after function name
		return Integer.valueOf("xyz3");
	}
	
	private static class MyException extends Exception {
		
	}
	
	// non-RuntimeExceptions are CheckedExceptions, must be caught or declare it.
	public static void throwCheckedException() throws MyException {
		try {
			throw new MyException();
		} catch (RuntimeException e) {
			
		}
	}
}
