package parking.lot.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import parking.lot.entity.Command;
import parking.lot.util.AppConstant;

public class InputService {
	private CommandService commandService;
	private ParkingService parkingService;

	public InputService(CommandService commandService, ParkingService parkingService) {
		this.commandService = commandService;
		this.parkingService = parkingService;
	}

	public void parseFile(String filePath) {
		File inputFile = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					parseInput(line.trim());
				}
			} catch (IOException ex) {
				System.out.println(AppConstant.ERROR_FILE_READ);
				ex.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(AppConstant.FILE_NOT_FOUND);
			e.printStackTrace();
		}
	}

	public void parseInput(String inputString) {
		String[] stringArray = inputString.split(" ");
		Command command = Command.getEnumFromString(stringArray[0]);
		if (command == null) {
			System.out.println(AppConstant.INVALID_INPUT);
			return;
		}
		Method method = commandService.getMap().get(stringArray[0]);
		if (method == null) {
			System.out.println(AppConstant.INVALID_INPUT);
			return;
		}
		try {
			switch (command) {
			case CREATE_PARKING_LOT:
				method.invoke(parkingService, stringArray[1]);
				break;
			case PARK:
				method.invoke(parkingService, stringArray[1], stringArray[2]);
				break;
			case LEAVE:
				method.invoke(parkingService, stringArray[1]);
				break;
			case STATUS:
				method.invoke(parkingService);
				break;
			case REGISTRATION_NUMBERS_FOR_CAR_WITH_COLOUR:
				method.invoke(parkingService, stringArray[1]);
				break;
			case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
				method.invoke(parkingService, stringArray[1]);
				break;
			case SLOT_NUMBERS_FOR_REGISTRATION_NUMBER:
				method.invoke(parkingService, stringArray[1]);
				break;
			default:
				System.out.println(AppConstant.INVALID_INPUT);
				break;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
