package abc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {

	public static void main(String[] args)  {
		
		TestException t=new TestException();
       
			t.task();
		
	}
	
public void task()  {
	fileRead();
	
}	
public void fileRead()  {
	
	/*try {
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Doubts.docx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
System.out.println("File read successfully");*/
	throw new ArithmeticException();
}}
