package billiards;

public class Line {

    private Point p1;
    private Momentum m1;
    private double slope = m1.getPy() / m1.getPx();
    private double yIntersection = -m1.getPy() / m1.getPx() * p1.getX() + p1.getY();;

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setM1(Momentum m1) {
        this.m1 = m1;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public void setyIntersection(double yIntersection) {
        this.yIntersection = yIntersection;
    }

    public Line(Point p, Momentum m){
        p1 = p;
        m1 = m;
    }
    public Point getP1() {
        return p1;
    }

    public Momentum getM1() {
        return m1;
    }

    public double getSlope() {
        return slope;
    }

    public double getyIntersection() {
        return yIntersection;
    }

    public Line(double slope, double yIntersection) {
        this.slope = slope;
        this.yIntersection = yIntersection;
    }

    public Line getLine(){
        slope = m1.getPy() / m1.getPx();
        yIntersection = -m1.getPy() / m1.getPx() * p1.getX() + p1.getY();
        return new Line(slope, yIntersection);
    }
}
