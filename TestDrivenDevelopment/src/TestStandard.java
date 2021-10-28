import static org.junit.Assert.*;
import org.junit.Test;
public class TestStandard {
	
	
	@Test
	public void testGet1Score() {
		Standard Standard1 = new Standard();
		Standard1.setIntScore("John", "Total", 100);
		assertEquals("One student returns wrong score", Standard1.getScore("John"), 100);
	}
	
	
	@Test
	public void testGet2Score() {
		Standard Standard1 = new Standard();
		Standard1.setIntScore("John", "Total", 100);
		assertEquals("One student returns wrong score", Standard1.getScore("John"), 100);
		Standard1.setIntScore("Sally", "Total", 30);
		assertEquals("Second student returns wrong score", Standard1.getScore("Sally"), 30);
	}
	
}