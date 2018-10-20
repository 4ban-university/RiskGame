import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LauncherTest {
    private Launcher launcher;

    @Before
    public void setUp(){
        launcher = new Launcher("Test", 100,100);
    }
    @Test
    public void launcherExistence(){
        System.out.println("Test 13: Launcher is created an menu object");
        assertTrue(launcher != null);
    }
}
