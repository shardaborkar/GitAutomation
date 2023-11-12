



package abc;

class ParentConstrChecking1 {
	ParentConstrChecking1(){
System.out.println("ParentConstrChecking constructor invoked");
}
int a=10;
public void task() {
	System.out.println(a);
}
}

class NewClass extends ParentConstrChecking1{
	NewClass(){
		this(20);
		System.out.println("ConstrChecking constructor invoked");
	}
	
	NewClass(int a){
		this.a=a;
		
		}
	int a;
	public static void main(String[] args) {
		ParentConstrChecking1 c=new NewClass();
		c.task();
		System.out.println(c.a);
			}
	public void task() {
		System.out.println(super.a)
		;
	}
	
}

