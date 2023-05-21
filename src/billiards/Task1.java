package billiards;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    private final int numberOfReflections = 20;

    public Point intersectionLineWithCircle(Line line){
        double a = line.getSlope() + 1;
        double b = 2 * line.getSlope()*line.getyIntersection();
        double c = line.getyIntersection()* line.getyIntersection() - 1;

        double d = b * b - 4 * a * c;

        double x1 = (-b + Math.sqrt(d))/(2*a);
        double x2 = (-b - Math.sqrt(d))/(2*a);

        double y1 = line.getSlope()*x1 + line.getyIntersection();
        double y2 = line.getSlope()*x2 + line.getyIntersection();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        if(line.getP1().getX() > x1){
            return p1;
        }
        else
            return p2;
    }

    public Momentum getNewMomentum(Point point, Momentum momentum){
        double q = 2*point.getX()*point.getY();
        double m = point.getY()*point.getY() - point.getX()*point.getX();
        double px1 = m*momentum.getPx()-2*q*momentum.getPy();
        double py1 = -q*momentum.getPx() + (-m*momentum.getPy());

        return new Momentum(px1, py1);
    }

    public List<Line> reflectionPoints(){
        List<Line> list = new ArrayList<>();
        Point initialPoint = Point.generatePointInsideUnitCircle();
        Momentum momentum = Momentum.generateRandomUnitMomentum1();
        list.add(new Line(initialPoint, momentum));
        Point newPoint = intersectionLineWithCircle(new Line(initialPoint, momentum));

        for(int i = 1; i < numberOfReflections; i++){
            list.add(new Line(newPoint, momentum));
            newPoint = intersectionLineWithCircle(new Line(newPoint, momentum));
        }
        return list;
    }

    public List<Line> reversibility(){
        double deviation = 0.001;
        List<Line> line = reflectionPoints();
        Line l = line.get(line.size()-1);
        double px = -l.getP1().getX();
        double py = -l.getP1().getY();

        double x = l.getP1().getX();
        double y = l.getP1().getY();

        Point p = new Point(x,y);
        Momentum m = new Momentum(px,py);
        List<Line> reversed = new ArrayList<>();
        reversed.add(new Line(p, m));
        Point newPoint = intersectionLineWithCircle(new Line(p, m));

        for(int i = 1; i < numberOfReflections; i++){
            reversed.add(new Line(newPoint, m));
            newPoint = intersectionLineWithCircle(new Line(p, m));
        }

        for(int i = 0; i < reversed.size(); i++){
            if(reversed.get(i).getSlope() - line.get(line.size()-i-1).getSlope() > deviation){
                System.out.println(i+1 + " -th reflection");
                break;
            }
        }

        return reversed;
    }
}
