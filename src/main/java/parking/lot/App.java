package parking.lot;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import parking.lot.service.CommandService;
import parking.lot.service.InputService;
import parking.lot.service.ParkingService;
import parking.lot.service.ParkingServiceImpl;

public class App {
	public static void main(String[] args) {
		String path = "/home/vaibhav/input.txt";
		Map<String, Method> map = new HashMap<String, Method>();
		CommandService commandService = new CommandService(map);
		ParkingService parkingService = new ParkingServiceImpl();
		InputService inputService = new InputService(commandService, parkingService);
		inputService.parseFile(path);
	}
}
