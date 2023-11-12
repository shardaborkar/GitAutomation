


 interface A {
	
	void run();
//	public void x() {}
	int c=10;
//	A(){}
//    static {System.out.println("static block");}
//    {System.out.println("instance block");}
	private void c(){System.out.println("private method");}
	
	  static void d() {System.out.println("static method");
	 System.out.println(c+1);
	 }
	default void a() {
		
		System.out.println("default method");
		c();
		
		
	}}



