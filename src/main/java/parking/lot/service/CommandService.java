package parking.lot.service;

import java.lang.reflect.Method;
import java.util.Map;

import parking.lot.entity.Command;

public class CommandService {

	private Map<String, Method> map;

	public CommandService(Map<String, Method> map) {
		this.map = map;
		populateCommandsHashMap();
	}

	private void populateCommandsHashMap() {
		try {
			map.put(Command.CREATE_PARKING_LOT.getValue(),
					ParkingService.class.getMethod("createParkingLot", String.class));
			map.put(Command.PARK.getValue(),
					ParkingService.class.getMethod("parkVehicle", String.class, String.class));
			map.put(Command.LEAVE.getValue(), ParkingService.class.getMethod("leaveParkingSlot", String.class));
			map.put(Command.STATUS.getValue(), ParkingService.class.getMethod("parkingStatus"));
			map.put(Command.REGISTRATION_NUMBERS_FOR_CAR_WITH_COLOUR.getValue(),
					ParkingService.class.getMethod("printRegistrationNumbersByColor", String.class));
			map.put(Command.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR.getValue(),
					ParkingService.class.getMethod("printSlotNumbersByColor", String.class));
			map.put(Command.SLOT_NUMBERS_FOR_REGISTRATION_NUMBER.getValue(),
					ParkingService.class.getMethod("printSlotNumberByRegNo", String.class));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

	public Map<String, Method> getMap() {
		return map;
	}

}
