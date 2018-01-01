package parking.lot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import parking.lot.service.CommandService;
import parking.lot.service.InputService;
import parking.lot.service.ParkingService;
import parking.lot.service.ParkingServiceImpl;

public class App {
	public static void main(String[] args) {
		Map<String, Method> map = new HashMap<String, Method>();
		CommandService commandService = new CommandService(map);
		ParkingService parkingService = new ParkingServiceImpl();

		InputService inputParser = new InputService(commandService, parkingService);
		switch (args.length) {
		case 0:
			System.out.println("Please enter '0' to quit");
			System.out.println("Waiting for input...");
			for (;;) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase("0")) {
						break;
					} else if ((inputString != null) && (inputString.length() > 0)) {
						inputParser.parseInput(inputString.trim());
					}
				} catch (IOException e) {
					System.out.println("Not able to read the input from console.");
					e.printStackTrace();
				}
			}
			break;
		case 1:
			inputParser.parseFile(args[0]);
			break;
		default:
			System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
		}
	}

}
