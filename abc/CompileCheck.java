class ParentConstrChecking4 {
	ParentConstrChecking4(){
System.out.println("ParentConstrChecking4 constructor invoked");
}
int a=10;
public void task() {
	System.out.println(a);
}
}

class CompileCheck extends ParentConstrChecking4{
	CompileCheck(){
		this(20);
		System.out.println("CompileCheck  constructor invoked");
	}
	
	CompileCheck(int a){
		this.a=a;
		
		}
	int a;
	public static void main(String[] args) {
		ParentConstrChecking4 c=new CompileCheck();
		c.task();
		System.out.println(c.a);
			}
	public void task() {
		System.out.println(super.a)
		;
	}
	
}

