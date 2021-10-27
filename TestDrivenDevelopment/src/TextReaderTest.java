import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextReaderTest {
	@Test
    public void test1() {
        TextReader test = new TextReader();
        assertEquals("Failed test", "test", test.test1());
    }
}
