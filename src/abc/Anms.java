package abc;

public class Anms {
	
	
		public static void main (String[] args) {
			 AnmsI o=new AnmsI() {
				  final int a=20;
				public void msg() {
				System.out.println("Annanmous class msg method");
				System.out.println(a);	
				o.printp();
				}
				
			};
			o.msg();
			o.print();
			AnmsI.prints();
			
			System.out.println(AnmsI.a);	
			
		}
		
		
		private void printp() {
			System.out.println("Private abc");
		}
			

}
