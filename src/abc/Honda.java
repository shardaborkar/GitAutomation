package abc;


class Bike{
	int speedlimit=90;


	public void task() {
		
		System.out.println("Parent Speed limit is:"+ " "+speedlimit);
	}
	
}


public class Honda extends Bike {
	int speedlimit=150;
	public static void main(String[] args) {
		Bike obj=new Honda();
		System.out.println("Parent Speed limit is:"+ " "+obj.speedlimit);
		obj.task();

	}
	
	public void task() {
		
		System.out.println(super.speedlimit);
	}

}
