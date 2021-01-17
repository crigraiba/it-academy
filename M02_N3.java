
// RELLOTGE DIGITAL

public class M02_N3 {

	public static void main(String[] args) throws InterruptedException {
		
		// 00:00:00
		
		for (int hour = 0; hour <= 23; hour++) {
			for (int minute = 0; minute <= 59; minute++) {
				for (int second = 0; second <= 59; second++) {
					if (hour < 10) {
						System.out.print("0"+hour);
					} else {
						System.out.print(hour);
					}
					if (minute < 10) {
						System.out.print(":0"+minute);
					} else {
						System.out.print(":"+minute);
					}
					if (second < 10) {
						System.out.print(":0"+second);
					} else {
						System.out.print(":"+second);
					}
					Thread.sleep(1000); // Unhandled exception type InterruptedException
					System.out.print("\b\b\b\b\b\b\b\b");
					if (hour == 23 && minute == 59 && second == 59) {
						hour = -1;
					}
				}
			}
		}
	}

}
