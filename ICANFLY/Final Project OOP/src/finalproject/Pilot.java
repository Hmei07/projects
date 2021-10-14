package finalproject;

import java.util.Random;

public class Pilot extends Flight{
	protected String name, id, kelas, type;
	Random rand = new Random();
	public Pilot(String kelas, String type) {
		setName();
		setKelas(kelas);
		setType(type);
		
	}

	public String getName() {
		return name;
	}

	void setName() {
		int random1, random2;
		String firstName = null, lastName = null;
		random1 = rand.nextInt(5)+1;
		random2 = rand.nextInt(5)+1;
		if(random1 == 1) firstName = "Bramantyo";
		else if(random1 == 2) firstName = "Rachel";
		else if(random1 == 2) firstName = "Gary";
		else if(random1 == 2) firstName = "Vilda";
		else if(random1 == 2) firstName = "Caroline";
		
		if(random2 == 1) lastName = " Meirdivitanto";
		else if(random2 == 2) lastName = " Reinardus";
		else if(random2 == 2) lastName = " Marvelim";
		else if(random2 == 2) lastName = " Yovira";
		else if(random2 == 2) lastName = " Hartanto";
		
		name = firstName + lastName;
	}
	
	

}
