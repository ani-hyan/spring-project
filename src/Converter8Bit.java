public class Converter8Bit extends Converter{

    @Override
    public Spring bitsIntoSpring(int[] bits) {
        String s = "";
        for(int i = 0; i < 8; i++){
            s += bits[i];
        }
        int decimal = Integer.parseInt(s, 2);
        return new Spring(decimal);
    }

    @Override
    public int evaluateDecimalValue(double[] frequencyAmplitudes) {
        return 0;
    }


}
