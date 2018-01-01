package parking.lot.service;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkingServiceTest {

	private ParkingService parkingService = new ParkingServiceImpl();

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void testCreateParkingLot() {
		parkingService.createParkingLot("8");
		assertTrue("created parking lot with 8 slots".equalsIgnoreCase(outContent.toString().trim()));
	}

}
