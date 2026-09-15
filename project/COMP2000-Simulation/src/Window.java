import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Window extends JFrame{
    //Window of the application
    //Defines screenspace

    public static int WIN_WIDTH = 800;
    public static int WIN_HEIGHT = 600;
    private final Sky sky; //changed to final - Allie
    private final Ground ground; //changed to final - Allie
    private final List<Plant> plants = new ArrayList<>();

    Window() {
        sky = new Sky();
        ground = new Ground();

        //Basic window props
        this.setTitle("GAASK Plant Simulation COMP2000");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Exit appliction when x pressed
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        //Keep the main sky and ground in a single column
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.fill=GridBagConstraints.HORIZONTAL;

        this.add(sky,c);
        this.add(ground,c);
        
        this.pack();
        this.setVisible(true);
    }

    //Sky will deal with it's own components, so anything added to the window 
    //must be added to the ground.
    public void addToGround(Component comp, Object constraints) {
        ground.add(comp, constraints);
        if(comp instanceof Plant plant){
            plants.add(plant);
        }
        refresh();
    }

    public void removeFromGround(Component comp) {
        ground.remove(comp);
        if(comp instanceof Plant plant){
            plants.remove(plant);
        }
        refresh();
    }

    public void refresh() {
        ground.revalidate();
        ground.repaint();
    }

    public Sky getSky(){
        return this.sky;
    }

    public List<Plant> getPlants(){
        return new ArrayList<>(plants);
    }
}
