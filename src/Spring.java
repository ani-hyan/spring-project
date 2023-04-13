//to be continued...
public class Spring {
    private double k;

    public Spring(){
        k = 1;
    }

    public Spring(double k){
        this.k = k;
    }

    public double getK(){
        return k;
    }

    private void setK(double k){
        this.k = k;
    }

    /**
     * @param t total time period of the oscillation
     * @param dt time step for each coordinate
     * @param x0 initial position of the mass
     * @param v0 initial velocity of the mass
     * @return an array of coordinates of an oscillating mass
     */
    public double[] move(double t, double dt, double x0, double v0){
        //number of coordinates
        int n = (int) ((int)t/dt);
        double[] coordinates = new double[n];
        double x = x0; //initial coordinate;
        double v = v0; //initial velocity;

        return coordinates;
    }

    /**
     *
     * @param t total time period of the oscillation
     * @param dt time step for each coordinate
     * @param x0 initial position of the mass
     * @return an array of coordinates of an oscillating mass
     */
    public double[] move(double t, double dt, double x0){
        //number of coordinates
        int n = (int) ((int)t/dt);
        double[] coordinates = new double[n];
        double x = x0; //initial coordinate;
        double v = 0; //initial velocity;

        return coordinates;
    }

    /**
     *
     * @param t0 initial start time
     * @param t1 end time of the oscillation
     * @param dt time step for each coordinate
     * @param x0 initial position of the mass
     * @param v0 initial velocity of the mass
     * @return an array of coordinates of an oscillating mass
     */
    public double[] move(double t0, double t1, double dt, double x0, double v0){
        int n = (int) ((int)t0-t1/dt);
        double[] coordinates = new double[n];
        double x = x0; //initial coordinate;
        double v = v0; //initial velocity;

        return coordinates;
    }

    /**
     *
     * @param t0 initial start time
     * @param t1 end time of the oscillation
     * @param dt time step for each coordinate
     * @param x0 initial position of the mass
     * @param v0 initial velocity of the mass
     * @param m a body of a specified mass
     * @return an array of coordinates of an oscillating mass
     */
    public double[] move(double t0, double t1, double dt, double x0, double v0, double m){
        int n = (int) ((int)t0-t1/dt);
        double[] coordinates = new double[n];
        double x = x0; //initial coordinate;
        double v = v0; //initial velocity;

        return coordinates;
    }
}
