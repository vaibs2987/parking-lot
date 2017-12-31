package parking.lot.entity;

public enum Command {
	CREATE_PARKING_LOT("create_parking_lot"),
	PARK("park"),
	LEAVE("leave"),
	STATUS("status"),
	REGISTRATION_NUMBERS_FOR_CAR_WITH_COLOUR("registration_numbers_for_cars_with_colour"),
	SLOT_NUMBERS_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour"),
	SLOT_NUMBERS_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number");

	private final String value;

	private Command(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getValue();
	}

}
