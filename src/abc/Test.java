package abc;

import first.Locator;

/*public class Test {
	static Test2 test2;
	public static void main(String[] args) {
		
	   test2=new Test2();  
	   Test test=new Test();
	   test.p();
	}
	void p() {
		test2.m(this);
	}
	
	void n() {
		
	System.out.println("N");
	}
}

class Test2 {

	public void m(Test test) {
		System.out.println("M");
		test.n();
	}

	
}
*/

/* class Test2 {
	Test test;
	
	
	Test2(Test test){
		 this.test=test;
		 
	}
	void p() {
		test.o();
	}
	
	void n() {
		
	System.out.println("N");
	}
}

 public class Test {
	Test2 test;
	public static void main(String[] args) {
		Test test=new Test();
		test.m();
		
		
	}
	

	public void m() {
		
		System.out.println("M");
		test=new Test2(this);
		test.p();
	}
	
	void o() {System.out.println("O");
	
	test.n();
	
	}
	

	
}

*/

/*class Test {
	
	
	public static void main(String[] args) {
		System.out.println("Main");
		Test2 test=new Test2();
		test.m();
}}
class Test2 {
	void m() {
		
		System.out.println("M");
	}
}*/

abstract class Test2{
	abstract void run();
	int q;
	Test2(){
		c=30;
		}
	
	{q=90;
	System.out.println(q);}
	
	static {b=40;}
	final int c;
	final static int b;
	private void d() {
		System.out.println("Private method");
		
	}
	
	protected void e(){
		System.out.println("Protected method");
		
	}
	 void a() {
		
		System.out.println("default method");
		System.out.println(c+" "+b);
		d();
	}
	 public void f(){
			System.out.println("public method");
			
		}
	 
	 static void g(){
			System.out.println("static method");
			
		}
	 
	 final void h(){
			System.out.println("final method");
			
		}

}


class Test extends Test2 {
	@Override
	public void run() {
		System.out.println("running");
		}
	public static void main(String[] args) {
		
		Test2 t=new Test();
		t.run();
		t.a();
		t.e();
		t.f();
		t.g();
		t.h();
		
	}
	/*@Override
	protected void b() {
		// TODO Auto-generated method stub
		
	}*/	
}


	
	



