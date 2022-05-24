package WS1.Nimbus1;

import java.util.Random;

public class RandomSupplier {
    private static final Random rnd = new Random(1);
    // final?

    public static Random getRnd() {
        return rnd;
    }
}
