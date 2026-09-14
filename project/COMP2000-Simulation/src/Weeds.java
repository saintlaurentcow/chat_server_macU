import java.awt.*;


public class Weeds extends Plant{

    Weeds(Point position, Window window){
        super(position, window);
        this.setBackground(Color.darkGray);
    }

    @Override

    public void spread(){
        Radius radius = new Radius(position, spreadRadius); //Typo in spread, fixed it - Allie

        for(int i = 0; i < spreadNum; i++){ //your r key might be broken, Sri. Might want to take a look at that. Also int i, not int o - Allie
            Point newPoint = radius.getRandomPoint();
             //size is an int type that you are trying to call as a Window type. I don't know what this does, so for now I'm supressing this. - Allie
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
    }

    @Override
    void deadAction() {
        //removed exceptions
    }

    
}
