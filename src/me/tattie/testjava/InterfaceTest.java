package me.tattie.testjava;

public class InterfaceTest implements MyInterface{
	
	{
		// field in interface are implicitly static and final
//		count++;
	}
	
	@Override
	public void foo() {}
	
	@Override
	public void goo() {}

	public static void main(String[] args) {

	}

}

interface MyInterface {
	// field in interface are implicitly static and final, so must provide a value here
	int count = 0;
	
	// by default, methods in interface are public
	void foo();
	
	// abstract method; by default, all methods are abstract in interface
	abstract void goo();
}
