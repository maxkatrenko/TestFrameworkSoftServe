import org.testng.annotations.BeforeSuite;

public class Parent {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("Before suite");
    }
}
