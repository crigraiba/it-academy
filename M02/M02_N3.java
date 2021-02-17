
package M02; // [Rellotge digital]

public class M02_N3 {

	public static void main(String[] args) {
		
		// 00:00:00
		
		String watch;
		for (int hour = 0; hour <= 23; hour++) {
			for (int minute = 0; minute <= 59; minute++) {
				for (int second = 0; second <= 59; second++) {
					if (hour < 10) {
						watch = "0"+hour;
					} else {
						watch = Integer.toString(hour);
					}
					if (minute < 10) {
						watch += ":0"+minute;
					} else {
						watch += ":"+minute;
					}
					if (second < 10) {
						watch += ":0"+second;
					} else {
						watch += ":"+second;
					}
					System.out.print(watch);
					try {
						Thread.sleep(1000); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // Unhandled exception type InterruptedException
					System.out.print("\b\b\b\b\b\b\b\b");
					if (hour == 23 && minute == 59 && second == 59) {
						hour = -1;
					}
				}
			}
			
			/* Alternativament:
			 * import java.time.LocalTime;
			 * import java.time.format.DateTimeFormatter;
			 * 
			 * while (true) {
			 *     LocalTime time = LocalTime.now();
			 *     String timeToShow = time.format(DateTimeFormatter.ISO_LOCAL_TIME);
			 *     String[] timeArray = timeToShow.split("\\.");
			 *     System.out.println(timeArray[0]);
			 * }
			 */
		}
	}

}
