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
        //net force is equal to the force of the spring: F = -k * x; am = -kx
        double a = -k*x;

        for(int i = 0; i < n; i++){
            coordinates[i] = x;
            v = a * dt;
            x = v * dt;
            a = -k*x;
        }

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
        return move(t, dt, x0, 0);
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0){
        return move(t0, t1, dt, x0, v0, 1);
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
        double a = -k/m*x;

        for(int i = 0; i < n; i++){
            coordinates[i] = x;
            v = a * dt;
            x = v * dt;
            a = -k/m*x;
        }

        return coordinates;
    }

    /**
     * Takes by reference a Spring that argument, connects
     * it with this Spring in series
     * @param that
     * @return equivalent spring
     */
    public Spring inSeries(Spring that){
        double kEq = (this.k * that.k)/(this.k + that.k);
        return new Spring(kEq);
    }

    /**
     * Takes by reference a Spring that argument,
     * connects it with this Spring in parallel
     * @param that
     * @return equivalent spring
     */
    public Spring inParallel(Spring that){
        double kEq = this.k + that.k;
        return new Spring(kEq);
    }

    @Override
    public String toString() {
        return "Spring " + this.k;
    }
}
