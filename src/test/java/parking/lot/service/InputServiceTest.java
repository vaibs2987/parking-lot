package parking.lot.service;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InputServiceTest {
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
		inputService.parseInput("create");
		assertTrue("Not a valid input.".equalsIgnoreCase(outContent.toString().trim()));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}
