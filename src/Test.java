
	class Test implements A {
		
		@Override
		public void run() {
			System.out.println("running");
			}
		
		public void a() {
			System.out.println("test a");
			}
		
/*		public void d() {
			System.out.println("test d");
			}*/
		public static void main(String[] args) {
			
			A t=new Test();
			t.run();
			t.a();
//			t.d();
			A.d();
			
			
		}
		
	}

