package parking.lot.service;

public interface ParkingService {

	public void createParkingLot(String lotCount);

	public void parkVechicle(String registrationNo, String color);

	public void leaveParkingSlot(String slotNo);

	public void printRegistrationNumbersByColor(String color);

	public void parkingStatus();

	public void printSlotNumberByRegNo(String regNo);

	public void printSlotNumbersByColor(String color);
}
