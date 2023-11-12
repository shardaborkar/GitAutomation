
 class Second {
	private final int instance_var=10;
	private final static int static_var=20;

	public void instanceMethod() {
	System.out.println(instance_var);
	System.out.println(static_var);
	instanceMethod1();//no need of object to call instance method from instance method in the same class
}

public void instanceMethod1() {
	System.out.println("instanceMethod1");
}


public static void staticMethod() {
//	System.out.println(instance_var);
	System.out.println(static_var);
}

 }

 class Heirarachy{
	public static void main (String[] args) {
		Second h=new Second();
		h.instanceMethod();
		h.staticMethod();//Calling static method with object is allowed but not recommended and not allowed in case of interface
//		instanceMethod(); because main is static hence object is required to call instance method
		Second.staticMethod();//no need of class name to call static method from static method/instance method in the same class
		Heirarachy s=new Heirarachy();
		s.instanceCall();//this is instance method calling from static method and hence object is required
		s();//calling static from static without class name in the same class
		
	}
	
	 
	
	public static void s() {System.out.println("calling static from static/instance method without class name in the same class");}
	
	public void instanceCall() {
		Second h1=new Second();
		h1.instanceMethod1();
		s();//calling static from instance without classname in the same class
	}
}
 
 



