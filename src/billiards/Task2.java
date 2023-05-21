package billiards;

public class Task2 {
    public double function(double x, Point p, Momentum m){
        double x1 = p.getX();
        double y1 = p.getY();
        double vx = m.getPx();
        double vy = m.getPy();

        return Math.pow(y1 + vy/vx - 9.8/2*x*x/vx*vx, 2) + x*x - 1;
    }
    public double root(double a, double b, Point p, Momentum m) {
        double c = (a + b) / 2;

        while (Math.abs(b - a) > 0.000001) {
            if (function(c, p, m) == 0.0) {
                return c;
            } else if (function(a, p, m) * function(b, p, m) < 0) {
                b = c;
            } else {
                a = c;
            }
            c = (a + b) / 2;
        }
        return c;
    }

    public Point intersectionParabolaWithCircle(Point p, Momentum m){
        double a = -9.8/2* 1/m.getPx();
        double b = m.getPy()/m.getPx();
        double c = p.getY();

        double vertexX = -b/2*a;
        double vertexY = -(b*b - 4*a*c)/4*a;

        if(Math.pow(vertexX,2) + Math.pow(vertexY,2)<= 1){
            double x = root(-1,1, p, m);
            double y = function(x, p, m);
            return new Point(x,y);
        }
        else{
            if(p.getX()>vertexX && p.getY() < vertexY){
                double x = root(vertexX, p.getX(), p, m);
                double y = function(x, p, m);
                return new Point(x,y);
            }
            else{
                double x = root(p.getX(), vertexX, p, m);
                double y = function(x, p, m);
                return new Point(x,y);
            }
        }
    }

}
