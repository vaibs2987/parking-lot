package parking.lot.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class InputServiceTest extends TestCase{
	private Map<String, Method> map = new HashMap<String, Method>();
	private CommandService commandService = new CommandService(map);
	private ParkingService parkingService = new ParkingServiceImpl();

	InputService inputService = new InputService(commandService, parkingService);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void parseTextInput() throws Exception {
		inputService.parseInput("hello");
		assertEquals("Invalidinput", outContent.toString().trim().replace(" ", ""));
		inputService.parseInput("status");
		assertEquals("Invalidinput\nSorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}
