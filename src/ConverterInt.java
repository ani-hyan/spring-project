public class ConverterInt extends Converter{
    @Override
    public Spring bitsIntoSpring(int[] bits) {
        int decimal = 0;
        int power = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            decimal += bits[i] * Math.pow(2, power);
            power++;
        }
        return new Spring(decimal);
    }

    @Override
    public int evaluateDecimalValue(double[] frequencyAmplitudes) {
        return 0;
    }
}
