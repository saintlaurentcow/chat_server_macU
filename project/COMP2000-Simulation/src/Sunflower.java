import java.awt.Color;
import java.awt.Point;

public class Sunflower extends Flower{
    //int size;

    Sunflower(Point position, Window window) {
        super(position, window);

        //Check if very close to another plant. If so, immediately die.
        //TODO
    }

    @Override 
    protected Color getBloomColor(){
        return Color.yellow;
    }

    @Override
    public void seedAction() {
    }

    @Override
    public void seedlingAction() {
    }

    @Override
    public void juvenileAction() {
    }

    @Override
    public void deadAction() {
    }

    @Override
    public void spread() {
        Radius radius = new Radius(position, spreadRadius);
        for(int i = 0; i < spreadNum; i++) {
            Point newPoint = radius.getRandomPoint();
            new Sunflower(newPoint, window);
        }
    }
}
