package finalproject;

public class Buy {
	protected String name, arrival, departure, airlineCode, flightType, kelas, seat, date,dateback;
	protected int passangerAmount;
	protected double boardingTime, boardingBackTime;
	
	public Buy(String name, String date, String dateback, String departure, String arrival, String airlineCode, String flightType, String kelas, double boardingTime, double boardingBackTime, String seat, int passangerAmount) {
		this.name = name;
		this.date = date;
		this.dateback = dateback;
		this.arrival = arrival;
		this.departure = departure;
		this.airlineCode = airlineCode;
		this.flightType = flightType;
		this.kelas = kelas;
		this.boardingTime = boardingTime;
		this.boardingBackTime = boardingBackTime;
		this.seat = seat;
		this.passangerAmount = passangerAmount;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	
	public String getAirlineName(){
		String a = "GARUDA";
		String b = "LION AIR";
		if(airlineCode.contains("GA")){
			return a;
		}
		else{
			return b;
		}
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getPassangerAmount() {
		return passangerAmount;
	}

	public void setPassangerAmount(int passangerAmount) {
		this.passangerAmount = passangerAmount;
	}

	public double getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(double boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateback() {
		return dateback;
	}

	public void setDateback(String dateback) {
		this.dateback = dateback;
	}

	public double getBoardingBackTime() {
		return boardingBackTime;
	}

	public void setBoardingBackTime(double boardingBackTime) {
		this.boardingBackTime = boardingBackTime;
	}

}
