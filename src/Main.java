public class Main {
    public static void main(String[] args) {
        Converter8Bit converter8Bits = new Converter8Bit();
        int[] bits1 = {1,1,0,0,1,1,0,1};
        Spring spring1 = converter8Bits.bitsIntoSpring(bits1);
        System.out.println(spring1.toString());

        ConverterInt converterInt = new ConverterInt();
        int[] bits2 = {1,1,0,0};
        Spring spring2 = converter8Bits.bitsIntoSpring(bits2);
        System.out.println(spring2.toString());

    }
}
