import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

abstract class Plant extends JPanel implements Growable {
    static final int SEED = 0;
    static final int SEEDLING = 1;
    static final int JUVENILE = 2;
    static final int ADULT = 3;
    static final int DEAD = 4;
    
    int growthState = SEED;
    int size = 60;
    Point position;

    int spreadNum;        //Max number of seeds a plant can produce
    int growthDelay;      //How long between growth states in milliseconds
    int spreadRadius;     //How far a plant can spread its seeds
    Window window;
    Timer timer;

    Plant(Point p, Window window) {
        //These numbers are all arbitrary placeholders for now
        this.window = window;
        this.position = p;

        spreadNum = 2;
        spreadRadius = 100;
        growthDelay = 5000;

        timer = new Timer();
        TimerTask grow = new TimerTask() {
            @Override
            public void run() {
                grow();
            }
        };

        TimerTask tick = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };

        timer.schedule(grow, growthDelay, growthDelay);
        timer.schedule(tick, 25, 25);

    

        this.setBounds(p.x-size/8, p.y-size/8, size/4, size/4);
        this.setBackground(Color.darkGray);
        window.addToGround(this, null); //leak here - Allie
    }

    protected int getInitialSpreadNum(){
        return 2; 
    }
    protected int getInitialSpreadRadius(){
        return 100;
    }
    protected int getInitialGrowthDelay(){
        return 5000;
    }
    protected boolean scalesWithGrowth(){
        return true;
    }



    //All plants will have these stages. The ___Action() methods allow each phase
    //to be customised per specific plant.
    public void tick() {
        switch(growthState) {
            case SEED -> {
                this.setBackground(new Color(79, 46, 9));
                seedAction();
            }
            case SEEDLING -> {
                this.setBackground(new Color(2, 184, 9));
                seedlingAction();
            }
            case JUVENILE -> {
                if (scalesWithGrowth()){
                    this.setBounds(position.x - size/4, position.y - size/4, size/2, size/2);
                }
                this.setBackground(new Color(1, 120, 5));
                juvenileAction();
            }
            case ADULT -> {
                if (scalesWithGrowth()){
                    this.setBounds(position.x - size/2, position.y - size/2, size, size);
                }
                this.setBackground(new Color(1, 71, 4));
                adultAction();
            }
            case DEAD -> {
                this.setBackground(Color.BLACK);
                deadAction();
                window.removeFromGround(this);
            }
        }
    }

    //Progress the lifespan of the plant
    @SuppressWarnings("override")
    public void grow() {
        if (growthState < DEAD){
            growthState++;
        }
    }

    abstract void seedAction();
    abstract void seedlingAction();
    abstract void juvenileAction();
    abstract void adultAction();
    abstract void deadAction();

    Point getPosition(){
        return position;
    }
}