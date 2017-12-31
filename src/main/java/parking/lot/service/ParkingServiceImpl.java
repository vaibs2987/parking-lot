package parking.lot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parking.lot.entity.Car;

public class ParkingServiceImpl implements ParkingService {
	int PARKING_SIZE = 0;
	Map<String, Car> carSlotMap;
	Map<String, String> carRegSlotMap;
	List<Integer> availableSlots;
	Map<String, List<String>> carColorMap;

	public void createParkingLot(String lotCount) {
		try {
			this.PARKING_SIZE = Integer.parseInt(lotCount);
		} catch (Exception e) {
			System.out.println("Invalid lot count");
			System.out.println();
			return;
		}
		availableSlots = new ArrayList<Integer>();
		for (int i = 1; i <= this.PARKING_SIZE; i++) {
			availableSlots.add(i);
		}
		this.carSlotMap = new HashMap<String, Car>();
		this.carRegSlotMap = new HashMap<String, String>();
		this.carColorMap = new HashMap<String, List<String>>();
		System.out.println("Created parking lot with " + lotCount + " slots");
	}

	public void parkVechicle(String registrationNo, String color) {
		if (this.PARKING_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created.");

			return;
		}
		if (this.carSlotMap.size() == this.PARKING_SIZE) {
			System.out.println("Sorry, parking lot is full");
			return;
		}
		Collections.sort(availableSlots);
		Car car = new Car(registrationNo, color);
		String currentSlot = availableSlots.get(0).toString();
		carSlotMap.put(currentSlot, car);
		carRegSlotMap.put(registrationNo, currentSlot);
		List<String> registrationList = null;
		if (carColorMap.containsKey(color)) {
			registrationList = carColorMap.get(color);
			carColorMap.remove(color);
			registrationList.add(registrationNo);
			carColorMap.put(color, registrationList);
		} else {
			registrationList = new ArrayList<String>();
			registrationList.add(registrationNo);
			carColorMap.put(color, registrationList);
		}
		System.out.println("Allocated slot number: " + currentSlot);
		availableSlots.remove(0);
	}

	public void leaveParkingSlot(String slotNo) {
		if (this.PARKING_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			return;
		}
		if (this.carSlotMap.size() == 0) {
			System.out.println("Parking lot is empty");
			System.out.println();
			return;
		}
		Car car = this.carSlotMap.get(slotNo);
		if (car == null) {
			System.out.println("Slot number " + slotNo + " is already empty");
			System.out.println();
			return;
		}
		String registrationNo = car.getRegistrationNo();
		String color = car.getColor();
		this.carSlotMap.remove(slotNo);
		this.carRegSlotMap.remove(registrationNo);
		List<String> registrationList = this.carColorMap.get(color);
		if (registrationList.contains(registrationNo)) {
			registrationList.remove(registrationNo);
		}
		this.availableSlots.add(Integer.parseInt(slotNo));
		System.out.println("Slot number " + slotNo + " is free");

	}

	public void printRegistrationNumbersByColor(String color) {
		if (this.PARKING_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			return;
		}
		if (this.carColorMap.containsKey(color)) {
			List<String> registrationList = this.carColorMap.get(color);
			for (int i = 0; i < registrationList.size(); i++) {
				if (i != registrationList.size() - 1) {
					System.out.print(registrationList.get(i) + ", ");
				} else {
					System.out.print(registrationList.get(i));
				}
			}
		} else {
			System.out.println("NA");
			System.out.println();
		}
	}

	public void parkingStatus() {
		if (this.PARKING_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			return;
		}
		if (carSlotMap.size() == 0) {
			System.out.println("Parking lot is empty");
			System.out.println();
			return;
		}
		System.out.println("Slot No.\tRegistration No\tColor");
		Car car;
		for (int i = 1; i <= this.PARKING_SIZE; i++) {
			String key = Integer.toString(i);
			if (this.carSlotMap.containsKey(key)) {
				car = this.carSlotMap.get(key);
				System.out.println(i + "\t" + car.getRegistrationNo() + "\t" + car.getColor());
			}
		}

	}

	public void printSlotNumberByRegNo(String regNo) {
		if (this.PARKING_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			return;
		}
		if (this.carRegSlotMap.containsKey(regNo)) {
			System.out.println(this.carRegSlotMap.get(regNo));
		} else {
			System.out.println("Not found");
			System.out.println();
		}
	}

	public void printSlotNumbersByColor(String color) {
		if (this.PARKING_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			return;
		}
		if (!carColorMap.containsKey(color)) {
			System.out.println("Not found");
			System.out.println();
			return;
		}

		List<String> regNoList = this.carColorMap.get(color);
		List<Integer> slotList = new ArrayList<Integer>();
		System.out.println();
		for (int i = 0; i < regNoList.size(); i++) {
			slotList.add(Integer.valueOf(this.carRegSlotMap.get(regNoList.get(i))));
		}
		Collections.sort(slotList);
		for (int j = 0; j < slotList.size(); j++) {
			if (j != slotList.size() - 1) {
				System.out.print(slotList.get(j) + ", ");
			} else {
				System.out.print(slotList.get(j));
			}
		}
		System.out.println();

	}

}
