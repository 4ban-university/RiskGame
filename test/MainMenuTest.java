import mapeditor.StartEditor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class MainMenuTest {
    private MainMenu window;

    @Before
    public void setUp() throws Exception {
        MainMenu window = new MainMenu("RiskGame by Team 3", 450, 250);
    }
}
