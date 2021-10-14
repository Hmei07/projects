package finalproject;

import java.util.Random;

public class Payment {
	Random rand = new Random();
	public Payment() {
		System.out.println();
		System.out.println("Currently our payment can only be done with BCA Virtual Account.");
		System.out.print("Please wait");
		for(int i=0 ; i<(rand.nextInt(10)+3) ; i++){
			try {
				Thread.sleep(1000);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	void calculate(){
		System.out.println();
		System.out.println("Below is the Virtual Account you should insert in BCA mobile/klikBCA:");
		System.out.println("808880" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) 
			+ rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10));
		System.out.println();
		System.out.print("Waiting for payment");
		for(int i=0 ; i<(rand.nextInt(10)+3) ; i++){
			try {
				Thread.sleep(1000);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.print("Payment success! Thank you for buying flight ticket with ICANFLY! (Press Enter to continue)");
	}

}
