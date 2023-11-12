package cmd;//When we specify package name in notepad then class file gets created in the same folder that is CMD and hence while compiling 
//we have to use command as javac -d .\ Cmd1.java and to run java cmd.Cmd1 because class file is present in the same folder 
//so no need of setting classpath and even while compiling if we give another location to save class file then also
//Class file will be created in the cd folder only and setting classpath has no impact and we ahve to use java cmd.Cmd1 to run the program
//Also in this case it is option to use d tag becuase the location of java and class file is same
//So we can even use it is javac Cmd1.java and java cmd.Cmd1 to run the program
//When we dont use package name while writing program then we can go for different path to save class file
//that is other than .java file  so we have to give destination in this case where we want to save the .class file
//C:\Users\Admin\eclipse-workspace\first\src\cmd>javac -d C:\Users\Admin\eclipse-workspace\first\src Cmd1.java
//C:\Users\Admin\eclipse-workspace\first\src\cmd>set classpath=C:\Users\Admin\eclipse-workspace\first\src;.;
//java Cmd1 to run the program as there is no package name present and hence we can run it without package name
//Below is way to run it using classpath switch
//C:\Users\Admin\eclipse-workspace\first\src\cmd>javac -d C:\Users\Admin\eclipse-workspace\first\src Cmd1.java

//C:\Users\Admin\eclipse-workspace\first\src\cmd>java -classpath C:\Users\Admin\eclipse-workspace\first\src Cmd1

class Bike1{
	int speedlimit=90;


	public void task() {
		
		System.out.println("Parent Speed limit is:"+ " "+speedlimit);
	}
	
}


public class Cmd1 extends Bike1 {
	int speedlimit=150;
	public static void main(String[] args) {
		Bike1 obj=new Cmd1();
		System.out.println("Parent Speed limit is:"+ " "+obj.speedlimit);
		obj.task();

	}
	
	public void task() {
		
		System.out.println(super.speedlimit);
	}

}
