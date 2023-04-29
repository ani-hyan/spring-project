public class ConverterFloat extends Converter{
    @Override
    public Spring bitsIntoSpring(int[] bits) {
        int bitsInt = 0;
        for (int i = 0; i < 32; i++) {
            bitsInt |= bits[i] << (31 - i);
        }
        return new Spring(Float.intBitsToFloat(bitsInt));
    }

    @Override
    public int evaluateDecimalValue(double[] frequencyAmplitudes) {
        return 0;
    }
}
