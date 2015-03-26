package me.tattie.testjava;

public class InnerClassTest {

    private int count = 0;

    private void foo() {
        System.out.println("foo()");

        // Outter can't visit Inner
        // Inner.this.value = 2;
        
        if (count > 0) {
        	final class Dummy {        		
        	}
        	Dummy d = new Dummy();
        }
        // can't visit local class outside the bracket
//        Dummy d = new Dummy();
        
        // can't create objects of abstract class
//        new AbsAdder();
    }
    
    public InnerClassTest addOneByInner() {
    	new Adder() {
    		@Override
    		public void addOne() {
            	InnerClassTest.this.count++;
            }
    		
    		// anonymous class can't have ctor, so use initialize block 
    		{
    			InnerClassTest.this.showCount();
    		}
    	}.addOne();
    	return this;
    }
    
    public void showCount() {
    	System.out.println("count == " + count);
    }
    
    public interface Adder {
    	void addOne();
    	
    	// all method in interface should be abstract and so can't have a body
//    	void foo() {}
    }
    
    abstract class AbsAdder {
    	void foo() {}
    }

    class Inner implements Adder {
        {
            System.out.println("Initializing Inner class.");

            // Inner can visit Outter, including private member
            InnerClassTest.this.foo();
        }
        
        @Override
        public void addOne() {
        	InnerClassTest.this.count++;
        }

        public int value = 1;

    }
    
    class Inner2 implements Adder {
    	@Override
        public void addOne() {
        	InnerClassTest.this.count++;
        }
    }

    public static void main(String[] args) {

    }
}

class Demo {
    public static void main(String[] args) {
        InnerClassTest outter = new InnerClassTest();
        // how to create an inner class
        InnerClassTest.Adder inner = outter.new Inner();
        inner.addOne();
        outter.showCount();

        InnerClassTest.Adder inner2 = outter.new Inner2();
        inner2.addOne();
        outter.showCount();
        
        outter.addOneByInner().showCount();
    }
}
