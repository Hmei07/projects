package finalproject;

import java.util.Scanner;
import java.util.Vector;

public class Main implements Airport {
	Scanner scan = new Scanner(System.in);
	Vector<String> airportlist = new Vector<>();
	Vector<String> airportlist2 = new Vector<>();
	Vector<Passanger> passengerList = new Vector<>();
	Vector<Buy> buyList = new Vector<>();
	Vector<Seat> seatList = new Vector<>();
	Vector<Airplane> airplaneList = new Vector<>();
	Vector<Flight> flightList = new Vector<>();
	
	public Main() {
		
		int choose = 0;
		do{
			try {
				menu();
				choose = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			
			switch (choose) {
			case 1:
				book();
				break;

			case 2:
				view();
				break;
				
			case 3:
				search();
				break;
				
			case 4:
				System.out.println("Thank you for using ICANFLY!");
				break;
			}
			
		}while(choose != 4);
	}

	public static void main(String[] args) {
		new Main();
	}
	
	void menu(){
		System.out.println(" _   ______       _       __      _   ________   _       __     __");
		System.out.println("| | |  ____|     / \\     |   \\   | | |  ______| | |      \\ \\   / /");
		System.out.println("| | | |         / _ \\    | |\\ \\  | | | |___     | |       \\ \\ / /");
		System.out.println("| | | |        / ___ \\   | | \\ \\ | | |  ___|    | |        \\ v /");
		System.out.println("| | | |____   / /   \\ \\  | |  \\ \\| | | |        | |____     | |");
		System.out.println("|_| |______| /_/     \\_\\ |_|   \\__ | |_|        |______|    |_|");
		System.out.println();
		System.out.println("	                   ,__");
		System.out.println("	                   |  `'.");
		System.out.println("	__           |`-._/_.:---`-.._");
		System.out.println("	\\='.       _/..--'`__         `'-._");
		System.out.println("	 \\- '-.--" + "`      ===        /   o  `',");
		System.out.println("	  )= (                 .--_ |       _.'");
		System.out.println("	 /_=.'-._             {=_-_ |   .--`-.");
		System.out.println("	/_.'    `\\`'-._        '-=   \\    _.'");
		System.out.println("	         )  _.-'`'-..       _..-'`");
		System.out.println("	        /_.'        `/" + ";';`|");
		System.out.println("	                     \\` .'/");
		System.out.println("	                      '--'");
		System.out.println("");
		System.out.println("Welcome to ICANFLY");
		System.out.println("Main menu:");
		System.out.println("1. Book flight ticket");
		System.out.println("2. View booked/bought ticket");
		System.out.println("3. Search bought ticket");
		System.out.println("4.Exit");
		System.out.print("Choose[1 - 4]: ");
	}
	
	void book(){
		Ticket ticket = new Ticket();
		
		//SET DEPARTURE AND ARRIVAL
		int depart = -1;
		System.out.println();
		airportList();
		do {
			try {
				System.out.print("Input the departure location[1 - 5]: ");
				depart = scan.nextInt()-1; scan.nextLine();					
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (depart < 0 || depart > 4);
		System.out.println(airportlist.get(depart) + " is selected as the departure location.");
		
		int arrival = -1;
		System.out.println();
		airportList(depart);
		do {
			try {
				System.out.print("Input the arrival location[1 - 4]: ");
				arrival = scan.nextInt()-1; scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (arrival < 0 || arrival > 3);
		System.out.println(airportlist2.get(arrival) + " is selected as the arrival location."); //CHECKER
		
		
		//SHOW LIST OF AIRLINES AND SET AIRLINE CHOCE
		int chooseAirline = -1;
		String airline = null;
		System.out.println();
		System.out.println("Airline list:");
		System.out.println("1. Garuda    2. Lion Air");
		do{
			try {
				System.out.print("Input the airline choice[1 - 2]: ");
				chooseAirline = scan.nextInt()-1; scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		}while(chooseAirline < 0 || chooseAirline > 1);
		if(chooseAirline == 0) airline = "Garuda";
		else if(chooseAirline == 1) airline = "Lion Air";
		System.out.println(airline + " is selected as the airline."); //CHECKER
		
		Airline airlines = new Airline(airline); //SAVE AIRLINE DATA
		airplaneList.add(new Airplane()); //ADD NEW AIRPLANE
		
		//SET FLIGHT TYPE
		String ppow;
		System.out.println();
		do {
			System.out.print("Input the flight type[one way | round trip]: ");
			ppow = scan.nextLine();			
		} while (!(ppow.equals("one way") || ppow.equals("round trip")));
		System.out.println(ppow + " is selected as the flight type."); //CHECKER
		
		//SET FLIGHT CLASS
		String kelas;
		System.out.println();
		do {
			System.out.print("Input flight class[economy | business]: ");
			kelas = scan.nextLine();
		} while (!(kelas.equals("economy") || kelas.equals("business")));
		System.out.println(kelas + " class is selected as the flight class"); //CHECKER
		
		flightList.add(new Pilot(kelas, ppow)); //ADD FLIGHT TYPE & CLASS AND GENERATE PILOT DATA
		
		//SET DEPARTURE DATE
		System.out.println();
		Integer day = 0, month = 0, year = 0;
		String date;
		do {
			try {
				System.out.print("Input departure date[dd mm yyyy]: ");
				day = scan.nextInt();
				month = scan.nextInt();
				year = scan.nextInt();		
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			if(month == 2 && year%4 == 0 && day > 29){
				day = 0;
				System.out.println("February " + year + " only have 28 days!");
			}
			if(month == 4 || month == 6 || month == 9 || month == 11){
				if(day == 31){
					day = 0;
					System.out.println("The chosen month doesn't have 31th day.");
				}
			}
		} while (day < 1 || day >31 || month < 1 || month > 12 || year < 2020 || year > 2021);

		System.out.println("Date set: " + day + "-" + month + "-" + year);
		date = day.toString() + "-" + month.toString() + "-" + year.toString();
		
		//SET FIRST BOARDING TIME
		System.out.println();
		int time = -1;
		Schedule schedule = new Schedule(airportlist.get(depart), airportlist2.get(arrival), kelas);
		schedule.showSchedule();
		do {
			try {
				System.out.print("Choose the boarding time for " + airportlist.get(depart) + 
						" - " + airportlist2.get(arrival) + "[1 - 18]: ");
				time = scan.nextInt()-1; scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while ( time < 0 || time > 17 );
		System.out.println(schedule.schedule.get(time) + " is selected as the boarding time for " 
		+ airportlist.get(depart) + " - " + airportlist2.get(arrival) + "."); //CHECKER
		
		//SET RETURN DATE IF ROUND TRIP
		String dateback = "";
		int dayback = 0, monthback = 0,yearback = 0;
		int timeback = 0;
		Schedule scheduleback = new Schedule(airportlist.get(depart), airportlist2.get(arrival), kelas);
		if(ppow.equals("round trip")){
			
			System.out.println();
			do {
				try {
					System.out.print("Input the return date[dd mm yyyy][max year: 2021]: ");
					dayback = scan.nextInt();
					monthback = scan.nextInt();
					yearback = scan.nextInt();				
				} catch (Exception e) {
					scan.nextLine();
				}
				if(yearback < year) yearback = 0;
				else if(yearback == year && monthback < month) monthback = 0;
				else if(yearback == year && monthback == month && dayback < day) day = 0;
			} while (dayback < 1 || dayback >31 || monthback < 1 || monthback > 12 || yearback < 2020 || yearback > 2021);
			System.out.println("Return date set: " + dayback + "-" + monthback + "-" + yearback);
			dateback = dayback + "-" + monthback + "-" + yearback;
			
			//SET RETURN BOARDING TIME IF ROUND TRIP
			System.out.println();
			scheduleback.showSchedule();
			do {
				try {
					System.out.print("Choose the boarding time for " + airportlist2.get(arrival) 
					+ " - " + airportlist.get(depart) + "[1 - 18]: ");
					timeback = scan.nextInt()-1; scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
			} while ( timeback < 0 || timeback > 17 );
			System.out.println(scheduleback.schedule.get(timeback) 
					+ " is selected as the boarding time for " + airportlist.get(depart) 
					+ " - " + airportlist2.get(arrival) + "."); //CHECKER
		}
		
		//SET PASSANGER AMOUNT
		System.out.println();
		int passenger = -1;
		do{
			try {
				System.out.print("Input the number of passenger[1 - ...]: ");
				passenger = scan.nextInt(); scan.nextLine();				
			} catch (Exception e) {
				scan.nextLine();
			}		
		}while(passenger < 1);
		System.out.println(passenger + " passenger(s) inputted."); //CHECKER
		
		//SET PASSANGER'S DATA(NAME, AGE, GENDER)
		System.out.println();
		String name, gender;
		int age = 0;
		for(int i=0 ; i<passenger ; i++){
			do {
				System.out.print("Enter the #" + (i+1) + " passenger's name[max 20 character]: ");
				name = scan.nextLine();		
			} while (!name.matches("[a-zA-Z ]+") || name.length() > 20 || name.length() < 1);
			
			do {
				try {
					System.out.print("Enter the #" + (i+1) + " passenger's age[1 - ...]: ");
					age = scan.nextInt();scan.nextLine();					
				} catch (Exception e) {
					scan.nextLine();
				}

			} while (age == 0);
			
			do {
				System.out.print("Enter the #" + (i+1) + " passenger's gender[male | female]: ");
				gender = scan.nextLine();
			} while (!(gender.equals("male") || gender.equals("female")));
			System.out.println();
			
			//SAVE PASSANGER'S DATA
			passengerList.add(new Passanger(name, age, gender));
			
			//SET SEAT NUMBER
			seatList.add(new Seat());
			if(seatList.size() > 1){
				for(int a=seatList.size()-2 ; a>=0 ; a--){
					if(seatList.get(seatList.size()-1).equals(seatList.get(a))){
						do {
							seatList.get(i).setNewSeatNum();
						} while (seatList.get(seatList.size()-1).equals(seatList.get(a)));
					}
				}
			}
			String seat = seatList.get(i).getSeatNum();
			
			//AMOUNT TICKET +1
			ticket.setAmount(i+1);
			
			//SAVE ALL DATA TO VECTOR BUYLIST
			buyList.add(new Buy(name, 
					date, 
					dateback, 
					airportlist.get(depart), 
					airportlist2.get(arrival), 
					airlines.getCode(), 
					ppow, 
					kelas, 
					schedule.schedule.get(time), 
					scheduleback.schedule.get(timeback), 
					seat, 
					passenger));
		}
		System.out.println("CART DETAILS ");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Departure     : " + buyList.get(buyList.size()-1).getDeparture());
		System.out.println("Arrival       : " + buyList.get(buyList.size()-1).getArrival());
		System.out.println("Date          : " + buyList.get(buyList.size()-1).getDate());
		System.out.println("1st Boarding  : " + buyList.get(buyList.size()-1).getBoardingTime());
		if(buyList.get(buyList.size()-1).getFlightType().equals("round trip")){
			System.out.println("Return date   : " + buyList.get(buyList.size()-1).getDateback());
			System.out.println("2nd Boarding  : " + buyList.get(buyList.size()-1).getBoardingBackTime());
		}
		
		System.out.println("Airline       : " + buyList.get(buyList.size()-1).getAirlineName());
		System.out.println("Passanger     : " + passenger + " person");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Fee           : Rp. " + (schedule.getPrice()*passenger) + ",-");
		if(buyList.get(buyList.size()-1).getDate().contains("17")){
			Double totalDisc = (double) (83*schedule.getPrice())*passenger/100;
			System.out.println("Discount(17%) : Rp. " + Math.ceil(totalDisc) +",-");
			System.out.println("---------------------------------------------------------------");
			System.out.println("Total         : Rp. " + ((schedule.getPrice()*passenger)-(Math.ceil(totalDisc))));
		}
		
		String bool;
		do {
			System.out.print("Do you like to proceed to payment? [yes | no]: ");
			bool = scan.nextLine();		
		} while (!(bool.equals("yes") || bool.equals("no")));
		if(bool.equals("no")){
			airplaneList.clear();
			flightList.clear();
			passengerList.clear();
			seatList.clear();
			buyList.clear();
			airportlist.clear();
			airportlist2.clear();
			return;
		}

		System.out.print("Your booking has been made,"
				+ " please proceed to payment. (Press Enter to continue)");scan.nextLine();
		
		Payment pay = new Payment();
		pay.calculate();
		scan.nextLine();
	}
	
	void view(){
		if(buyList.isEmpty()) {
			System.out.print("You haven't bought any tickets! (Press Enter to continue)"); scan.nextLine();
		}
		else{
			System.out.println("Ticket list:");
			for(int i=0 ; i<buyList.size(); i++){
				System.out.println();
				System.out.println(" _________________________________________________________");
				System.out.printf("| %-14s                                          |\n", buyList.get(i).getAirlineName());
				System.out.printf("| %10s TICKET [%-8s]                            |\n", buyList.get(i).getFlightType().toUpperCase(), 
						buyList.get(i).getKelas().toUpperCase());
				System.out.println("|---------------------------------------------------------|");
				System.out.printf("| Full name    : %-20s          _          |\n", buyList.get(i).getName());
				System.out.printf("| Flight number: %-6s                      -=\\`\\        |\n", buyList.get(i).getAirlineCode());
				System.out.printf("| Date         : %-10s              |\\ ____\\_\\____   |\n", buyList.get(i).getDate());
				System.out.printf("| Seat number  : %-2s                    -=\\c`''''''''' '`)|\n", buyList.get(i).getSeat());
				System.out.printf("| Boarding time: %.2f                    `~~~~~/ /~~~~`  |\n", buyList.get(i).getBoardingTime());
				System.out.printf("| Departure    : %-10s                 -==/ /        |\n", buyList.get(i).getDeparture());
				System.out.printf("| Arrival      : %-10s                   '-'         |\n", buyList.get(i).getArrival());
				if(buyList.get(i).getFlightType().equals("round trip"))
				System.out.printf("| Return date  : %-10s                               |\n", buyList.get(i).getDateback());
				System.out.println("|_________________________________________________________|");
			}
			scan.nextLine();
		}
	}
	
	void search(){
		if(buyList.isEmpty()){
			System.out.print("No tickets bought yet! (Press Enter to continue)");
			scan.nextLine();
		}
		else{
			int nElements = buyList.size()-1;
			String key;
			System.out.print("Please enter the passenger's name you want to search: ");
			key = scan.nextLine();
			System.out.println("Please wait");
			System.out.println();
			System.out.println("Results:");
			Runnable a = new LinearSearch(0, (nElements/2), key, buyList);
			Runnable b = new LinearSearch(nElements/2+1, nElements, key, buyList);
			Thread threada = new Thread(a);
			Thread threadb = new Thread(b);
			threada.start();
			try {
				threada.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			threadb.start();
			try {
				threadb.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println();
			System.out.print("Press Enter to continue.");
			scan.nextLine();
		}

	}

	@Override
	public void airportList() {
		if(airportlist.size() != 5){
			airportlist.clear();
			airportlist.add("Jakarta");
			airportlist.add("Bandung");
			airportlist.add("Semarang");
			airportlist.add("Surabaya");
			airportlist.add("Yogyakarta");
		}
		
		System.out.println("Available airport for departure:");
		for(int i=0 ; i<airportlist.size() ; i++){
			System.out.print((i+1) + ". " + airportlist.get(i) + "   ");
		}
		System.out.println();
	}

	@Override
	public void airportList(int choosen) {
		airportlist2.clear();
		airportlist2.addAll(airportlist);
		airportlist2.remove(choosen);
		System.out.println("Available airport for arrival:");
		for(int i=0 ; i<airportlist2.size() ; i++){
			System.out.print((i+1) + ". " + airportlist2.get(i) + "   ");
		}
		System.out.println();
		
	}
	
	
}
