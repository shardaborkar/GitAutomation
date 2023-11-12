package abc;

public interface AnmsI {
	int a=10;
    void msg();

default void print() {
	
	System.out.println("Outer class print method");
	
}

static void prints() {
	
	System.out.println("Outer class static print method");
	
}

private void printp() {
	
	System.out.println("Outer class private print method");
	
}



}
