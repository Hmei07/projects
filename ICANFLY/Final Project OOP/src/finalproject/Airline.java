package finalproject;

import java.util.Random;

public class Airline {
	protected String name, code;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Airline(String airline){
		Random rand = new Random();
		int random;
		
		do {
			random = rand.nextInt(1000);
		} while (random < 100);
		
		if(airline.equals("Garuda")){
			code = "GA-" + random;
		}
		else if(airline.equals("Lion Air")){
			code = "JT-" + random;
		}
	}

}
