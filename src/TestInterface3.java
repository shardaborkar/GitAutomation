

	abstract class TestInterface1 implements Showable,Printable{  
		public void print(){System.out.println("Hello");}  

		public void show(){System.out.println("show  method");}  
		  }

		abstract class TestInterface2 extends TestInterface1{
			TestInterface2(){System.out.println("TestInterface2 constructor invoked");}
			static {System.out.println("Static block of TestInterface2 invoked");}
			{System.out.println("Instance block of TestInterface2 invoked");}
			public void show(){System.out.println("Welcome show");}  
			int instanceVar=30;
		}



		class TestInterface3 extends TestInterface2{
			int instanceVar=10;
			static int staticVar=20;
			TestInterface3(){System.out.println("TestInterface3 constructor invoked");}
			static {System.out.println("Static block of TestInterface3 invoked");
			System.out.println(staticVar);
//			System.out.println(instanceVar);
			}
			{System.out.println("Instance block of TestInterface3 invoked");
			System.out.println(staticVar);
			System.out.println(instanceVar);
			}
				
				
			
			
		
		public static void main(String args[]){  
		TestInterface3 obj = new TestInterface3();  
		obj.print();  
		obj.show();  
		obj.a();
		obj.b();
		 }  

		public void a(){
		System.out.println("a");
		}

		public void b(){
		System.out.println("b");
		}

/*		public void show(){System.out.println("show child method");}  
		public void print(){System.out.println("print child method");}  */

		}  




