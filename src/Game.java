import ui.MainWindow;

public class Game {

    private MainWindow window;

    public int width, height;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;

        window = new MainWindow(title, width, height);
    }

}