package parking.lot.service;

public interface ParkingService {

	/**
	 * Creating parking lot if it is not created already
	 * 
	 * @param lotCount
	 */
	public void createParkingLot(String lotCount);

	/**
	 * This method is responsible for providing the slot for parking the
	 * vehicle.
	 * 
	 * @param registrationNo
	 * @param color
	 */
	public void parkVehicle(String registrationNo, String color);

	/**
	 * This method is responsible for making a parking slot free.
	 * 
	 * @param slotNo
	 */
	public void leaveParkingSlot(String slotNo);

	/**
	 * This method is responsible for printing the vehicle registration number
	 * using color.
	 * 
	 * @param color
	 */
	public void printRegistrationNumbersByColor(String color);

	/**
	 * This method is responsible for providing the status of all slots.
	 * 
	 */
	public void parkingStatus();

	/**
	 * This method is responsible for providing the slot of a particular parked
	 * vehicle by using registration no.
	 * 
	 * @param regNo
	 */
	public void printSlotNumberByRegNo(String regNo);

	/**
	 * This method is responsible for providing the slot of a particular parked
	 * vehicle using color
	 * 
	 * @param color
	 */
	public void printSlotNumbersByColor(String color);
}
