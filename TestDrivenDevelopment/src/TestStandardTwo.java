import static org.junit.Assert.*;
import org.junit.Test;
public class TestStandardTwo {
	
	@Test
	public void testGetScore() {
		StandardTwo St2 = new StandardTwo();
		St2.setAnswers("Did you code? @ 75", true);
		assertEquals("The score is not 0", St2.getScore(), 0);
	}
	
}
