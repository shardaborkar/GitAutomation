package abc;

  public class ConstrScope {
	   protected int a=10;
	   protected static int b=20;
	 public ConstrScope(){
		
		System.out.println("ConstrScope constructor invoked");
	}
	/* public static void main(String[] args) {
		 ConstrScope c=new ConstrScope();
		 c.access();
	 }*/
	 protected void access() {
			System.out.println("I a accessible");
		//	System.out.println(a);	
		//	System.out.println(b);
			
	}
	
/*	public static void main(String[] args) {
		ConstrScope c=new ConstrScope();
		System.out.println("ConstrScope Main method");
	}*/
}
