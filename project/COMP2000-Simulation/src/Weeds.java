import java.awt.*;


public class Weeds extends Plant{

    Weeds(Point position, Window window){
        super(position, window);
        this.setBackground(Color.darkGray);
    }

    @Override 
    protected int getInitialGrowthDelay(){
        return 1500;
    }

    @Override 
    protected int getInitialSpreadNum(){
        return 4;
    }

    @Override 
    protected boolean scalesWithGrowth(){
        return false;
    }

    @Override
     public void spread(){
        Radius radius = new Radius(position, spreadRadius); //Typo in spread, fixed it - Allie
        for(int i = 0; i < spreadNum; i++){ //your r key might be broken, Sri. Might want to take a look at that. Also int i, not int o - Allie
            Point newPoint = radius.getRandomPoint();
            new Weeds(newPoint, window);
        }
    }

    @Override
    void seedAction() {
    }

    @Override
    void seedlingAction() {
    }

    @Override
    void juvenileAction() {
    }

    @Override
    void adultAction() {
        if ((int) (Math.random() * 100) < 3){
            spread();
        }
    }

    @Override
    void deadAction() {
    }

    
}
