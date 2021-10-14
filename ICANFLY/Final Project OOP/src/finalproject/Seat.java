package finalproject;

import java.util.Random;

public class Seat {
	protected String seatNum;
	Random rand = new Random();
	String alphabet = "ABCDEF";
	public Seat() {
		Integer random1 = rand.nextInt(22)+21;
		char random2 = alphabet.charAt(rand.nextInt(alphabet.length()));
		seatNum = random1.toString() + random2;
		
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	
	void setNewSeatNum(){
		Integer random1 = rand.nextInt(22)+21;
		char random2 = alphabet.charAt(rand.nextInt(alphabet.length()));
		seatNum = random1.toString() + random2;
	}
}
