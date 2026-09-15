import java.awt.*;

public class App {
    public static void main(String[] args) {
        Window window = new Window();
        Controller controller = new Controller(window);// Starts controller and weather timer
       
        new Sunflower(new Point(200, 200), window);
        new Sunflower(new Point(400, 250), window);
        new Weeds(new Point(600, 200), window);
    }
}
