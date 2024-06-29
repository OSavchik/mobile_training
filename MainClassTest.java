import org.junit.Test;
import org.junit.Assert;

public class MainClassTest extends MainClass  {

    @Test
    public void testGetLocalNumber() {
        if (getLocalNumber() == 14 ) System.out.println("Method getLocalNumber return correct result" + " " +  getLocalNumber());
        else System.out.println("Method getLocalNumber return not correct result" + " " +  getLocalNumber());
    }
    @Test
    public void testGetClassNumber() {
        if (getClassNumber() > 45 ) System.out.println("Method getClassNumber return correct  result" + " " + getClassNumber());
        else System.out.println("Method getLocalNumber return not correct result" + " "  + getClassNumber());
    }
    @Test
    public void testGetClassString() {
        boolean contains = getClassString().contains("Hello") || getClassString().contains("hello") ;
        Assert.assertTrue("Test not found correct substring", contains);
    }
}
