import org.junit.Assert;
import org.junit.Test;

public class TwoTest {

    @Test
    public void emailTest() {
        Two two = new Two();
        Assert.assertEquals("foo", two.foo());
    }
}