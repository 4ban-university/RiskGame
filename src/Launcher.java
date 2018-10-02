import ui.MainWindow;

public class Launcher {

    private MainWindow window;

    public int width, height;

    public Launcher(String title, int width, int height){
        this.width = width;
        this.height = height;
        window = new MainWindow(title, width, height);
    }

    public static void main(String[] args){
        new Launcher("RiskGame by Team 3", 800, 500);
    }

}