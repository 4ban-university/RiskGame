import ui.MainWindow;

/**
 * The type Launcher.
 */
public class Launcher {

    private MainWindow window;
    public int width, height;

    /**
     * Instantiates a new Launcher.
     *
     * @param title  the title
     * @param width  the width
     * @param height the height
     */
    public Launcher(String title, int width, int height){
        this.width = width;
        this.height = height;
        window = new MainWindow(title, width, height);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        new Launcher("RiskGame by Team 3", 1300, 800);
    }

}