package abc;

public abstract class OuterClass {
	
	   static final int a=10;
	    abstract void msg();
	
	static void print() {
		
		System.out.println("Outer class print method");
		
	}


}
	

		
		//OuterClass.InnerClass i=o.new InnerClass();
		//i.msg1();
	
	
	/* class InnerClass {
		  final int b=20;
		 void msg1() {
			int c=30;
			System.out.println("Inner class msg method");
			msg();
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}*/
	


