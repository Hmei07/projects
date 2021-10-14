package finalproject;

import java.util.ArrayList;

public class Schedule {
	protected String arrival, departure;
	protected int time, price;
	ArrayList<Double> schedule = new ArrayList<>();
	
	void addSchedule(){
		if(schedule.isEmpty()){
			for(double i=06.15 ; i<24.00 ; i++){
				schedule.add(i);
			}
		}
	}
	
	void showSchedule(){
		System.out.println("");
		for(int i=0 ; i<schedule.size()-12 ; i++){
			System.out.println((i+1) + ". " + schedule.get(i)
			+ "    " + (i+7) + ". " + schedule.get(i+6) + "    "
					+ (i+13) + ". " + schedule.get(i+12));
		}
	}
	
	public Schedule(String depart, String arrival, String kelas) {
		this.departure = depart;
		this.arrival = arrival;
		addSchedule();
		if(depart.equals("Jakarta")){
			if(arrival.equals("Bandung")){
				time = 25;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Semarang")){
				time = 65;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Surabaya")){
				time = 105;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Yogyakarta")){
				time = 70;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
		}
		else if(depart.equals("Bandung")){
			if(arrival.equals("Jakarta")){
				time = 25;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Semarang")){
				time = 50;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Surabaya")){
				time = 90;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Yogyakarta")){
				time = 55;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}			
		}
		else if(depart.equals("Semarang")){
			if(arrival.equals("Jakarta")){
				time = 65;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Bandung")){
				time = 50;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Surabaya")){
				time = 45;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Yogyakarta")){
				time = 20;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}			
		}
		else if(depart.equals("Surabaya")){
			if(arrival.equals("Jakarta")){
				time = 105;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Bandung")){
				time = 90;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Semarang")){
				time = 45;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Yogyakarta")){
				time = 45;
				price = time*10000;
			}			
		}
		else if(depart.equals("Yogyakarta")){
			if(arrival.equals("Jakarta")){
				time = 70;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Bandung")){
				time = 55;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Semarang")){
				time = 20;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}
			else if(arrival.equals("Surabaya")){
				time = 45;
				if(kelas.equals("economy"))price = time*10000;
				else if(kelas.equals("business"))price = time*12000;
			}			
		}
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
