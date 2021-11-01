import static org.junit.Assert.*;
import org.junit.Test;

public class Standard3Test {
	
	@Test
	public void getTotalPoints1() {
		int totalPoints = 5;
		Standard3 s = new Standard3(totalPoints);
		assertEquals("Total points for standard 3 incorrect", totalPoints, s.getTotalPoints());
	}
}
