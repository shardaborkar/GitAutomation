package abc;

 class ParentConstrChecking {
	ParentConstrChecking(){
System.out.println("ParentConstrChecking constructor invoked");
}
int a=10;
public void task() {
	System.out.println(a);
}
}

class ConstrChecking extends ParentConstrChecking{
	ConstrChecking(){
		this(20);
		System.out.println("ConstrChecking constructor invoked");
	}
	
	ConstrChecking(int a){
		this.a=a;
		
		}
	int a;
	//static ConstrChecking c1;
	public static void main(String[] args) {
		ParentConstrChecking c=new ConstrChecking();
		c.task();
//		c.work();
		ConstrChecking c1=new ConstrChecking();
		c1.work();
		System.out.println(c.a);
		System.out.println(c1.a);
			}
	public void task() {
		System.out.println(super.a);
		work();
	}
	
	public void work() {
		System.out.println("work method" )
		;
	}
	
}
