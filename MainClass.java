import org.junit.Test;

public class MainClass {
    private int class_number = 20;
    private String  class_string = "Hello, world";

    public void myFirstTest() {
        System.out.println("Method getLocalNumber return " + this.getLocalNumber());
        System.out.println("Method getClassNumber return " + this.getClassNumber());
    }
    public int getLocalNumber() {
        return 14;
    }
    public int getClassNumber() {
        return class_number;
    }

    public String  getClassString() {
        return class_string;
    }

}
