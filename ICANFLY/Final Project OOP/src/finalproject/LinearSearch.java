package finalproject;
import java.util.Scanner;
import java.util.Vector;

public class LinearSearch implements Runnable {

	private int startIndex, endIndex;
	private static String key;
	static Vector<Buy> buyList = new Vector<>();
	public static Scanner scanner = new Scanner(System.in);
	
	public LinearSearch(int startIndex, int endIndex, String key, Vector<Buy> buy) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		LinearSearch.key = key;
		LinearSearch.buyList.clear();
		LinearSearch.buyList.addAll(buy);
	}
	
	@Override
	public void run() {
		for(int i = startIndex; i<=endIndex; i++) {
			if(buyList.get(i).getName().contains(key)) {
				System.out.println();
				System.out.println();
				System.out.println(" _________________________________________________________");
				System.out.printf("| %-14s                                          |\n", buyList.get(i).getAirlineName());
				System.out.printf("| %10s TICKET [%-8s]                            |\n", 
						buyList.get(i).getFlightType().toUpperCase(), buyList.get(i).getKelas().toUpperCase());
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
				System.out.println();
				return;
			}
		}
	}
}