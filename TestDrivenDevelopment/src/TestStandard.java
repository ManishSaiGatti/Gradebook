import static org.junit.Assert.*;
import org.junit.Test;
public class TestStandard {
	
	
	@Test
	public void testGet1Score() {
		Standard Standard1 = new Standard();
		Standard1.setIntScore("John", "Total", true);
		assertEquals("One student returns correct answer", Standard1.getScore("John"), true);
	}
	
	
	@Test
	public void testGet2Score() {
		Standard Standard1 = new Standard();
		Standard1.setIntScore("John", "Total", true);
		assertEquals("One student returns correct answer", Standard1.getScore("John"), true);
		Standard1.setIntScore("Sally", "Total", false);
		assertEquals("Second student returns wrong answer", Standard1.getScore("Sally"), false);
	}
	
	@Test
	public void testRoster() {
		Standard Standard1 = new Standard();
		Standard1.setIntScore("John", "Total", true);
		assertEquals("One student returns correct answer", Standard1.getScore("John"), true);
		Standard1.setIntScore("Eric", "Total", false);
		assertEquals("One student returns wrong answer", Standard1.getScore("Eric"), false);
		
	}
	
}