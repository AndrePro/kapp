import org.junit.Assert;
import org.junit.Test;

public class OneTest {

    @Test
    public void emailTest() {
        One one = new One();
        one.message = "message";
        Assert.assertEquals("message", one.message);
    }
}