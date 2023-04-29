public class FT {
    private int N; // number of samples
    private double period, delta;
    private double omega0 ;
    private double[] x; // array of coordinate values

    public FT(double[] x, double delta) {
        N = x.length;
        this.x = x;
        this.delta = delta;
        period = N * delta;
        omega0 = omega0 = 2*Math.PI / period ;
    }

    double getSinCoefficient(int n, double x) {
        double sum = 0 ;
        double t = 0 ;
        for(int i = 0; i < N; i++) {
            sum += x * Math.sin( n*omega0* t ) ;
            t += delta;
        }
        return 2* delta*sum/period ;
    }


    double getCosCoefficient(int n, double x) {
        double sum = 0 ;
        double t = 0 ;
        for(int i = 0; i < N; i++) {
            sum +=  x* Math.cos( n*omega0* t ) ;
            t += delta;
        }
        return 2* delta*sum/period ;
    }

    public double[] getAmplitudes() {
        double[] amplitudes = new double[N];
        for(int i = 0; i < N; i++){
            double sin = getSinCoefficient(N, x[i]);
            double cos = getCosCoefficient(N, x[i]);
            amplitudes[i] = Math.sqrt(sin*sin + cos*cos)/N;
        }

        return amplitudes;
    }
}
