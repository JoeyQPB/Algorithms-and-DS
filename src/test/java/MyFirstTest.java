import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFirstTest {

    @Test
    public void testSum() {
        int a = 5;
        int b = 10;
        int sum = a + b;
        assertEquals(15, sum);
    }
}
