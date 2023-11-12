class ParentConstrChecking3 {
	ParentConstrChecking3(){
System.out.println("ParentConstrChecking3 constructor invoked");
}
int a=10;
public void task() {
	System.out.println(a);
}
}

class NewClass1 extends ParentConstrChecking3{
	NewClass1(){
		this(20);
		System.out.println("NewClass1 constructor invoked");
	}
	
	NewClass1(int a){
		this.a=a;
		
		}
	int a;
	public static void main(String[] args) {
		ParentConstrChecking3 c=new NewClass1();
		c.task();
		System.out.println(c.a);
			}
	public void task() {
		System.out.println(super.a)
		;
	}
	
}

