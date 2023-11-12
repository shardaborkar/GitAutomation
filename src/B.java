import abc.ConstrScope;

public class B extends ConstrScope {
	int ins=30;// We can't access default class outside the package
public static void main(String[] args) {
	//ConstrScope c=new B();// We can't access default class outside the package
	B c=new B();
	c.access();   
	 System.out.println(ConstrScope.b);  
	 System.out.println(c.a);  
	 System.out.println(c.ins);                    //Since the constructor is protected and we don't inherit constructor it is asking to change the visibility to public
}


}

//If class  is default then we can not instantiate the class outside the package no  matter what is the access modifier for constructor
//If class is public and constructor is default it can not instantiate the class from outside the package and if we want then constructor access modifier needs to be changed to public
//If class is public and constructor is protected it can not instantiate the class from outside the package and if we want then constructor access modifier needs to be changed to public
//because constructor is never inherited
//If class is public and constructor is private we can not instantiate the class from outside the package
//Hence if you want to make an instance of class from outside the package then class and constructor has to be public