package billiards;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    private double L;
    private final int numberOfReflections = 20;
    public Point intersectionWithStadium(Point p, Momentum m){

        Line line = new Line(p, m);
        if(m.getPy() > 0 ){
            double y = line.getSlope()*(-1) + line.getyIntersection();
            //bottom line
            if(y >= -L && y <= L){
                return new Point(-1, y);
            }
            //bottom circle
            else{
                return new Point(-Math.sqrt(1-y*y), y);
            }
        }
        else{
            double y = line.getSlope() + line.getyIntersection();
            //upper line
            if(y >= -L && y<=L){
                return new Point(1, y);
            }
            //upper circle
            else{
                return new Point(Math.sqrt(1-y*y), y);
            }
        }
    }

    public Momentum generateNewMomentum(Point point, Momentum momentum, double xc) {
        if(point.getY() >= -L && point.getY()<=L){
            return new Momentum(momentum.getPx(), -momentum.getPy());
        }
        double x = point.getX();
        double y = point.getY();
        double px = momentum.getPx();
        double py = momentum.getPy();

        double a = Math.pow(y, 2) - Math.pow(x - xc, 2);
        double b = -2 * (x - xc) * y;
        return new Momentum(a * px + b * py, b * px - a * py);

    }

    public List<Line> reflectionPoints(){
        List<Line> list = new ArrayList<>();
        Point p = Point.generatePointInsideUnitCircle();
        Momentum m = Momentum.generateRandomUnitMomentum1();
        Point point  = intersectionWithStadium(p, m);
        for (int i = 0; i < numberOfReflections; i++){
            list.add(new Line(point, m));
            point = intersectionWithStadium(point, m);
        }
        return list;
    }
}
