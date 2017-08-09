import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    private static final byte[] a = new byte[]{124, 14, -69, -110, -25, 2, 36, 2, 43, -5, -40, -71, -108, -107, -44, 36, 3, -32, 29, -113, 56, 52, -81, -71, 45, 8, 66, -82, -76, -122, 42, -2, -120, 33, -85, 83, -122, -3, -8, 62, -117, 58, -95, 106, -105, -13, 34, -68, 39, -29, 30, -116, 27, -17, -92, 22, 75, 116, -85, 126, -13, 67, -107, -15};
    private static final byte[] b = new byte[]{-33, -96, 83, 106, -88, 88, 23, -7, 106, 113, -94, 91, -12, -37, -88, 32, -26, -116, -2, 84, -75, 33, 44, 29, -113, -58, 11, -118, 61, -76, 27, -98, 42, 72, 63, 14, 14, -58, 52, 97, 82, 39, -108, 57, -111, 1, 71, -64, -52, -62, -106, -2, 125, 15, -116, 24, 65, 31, 89, 118, 76, 92, -45, 103};
    private static final byte[] e = new byte[]{-34, -94, 80, 110, -83, 94, 16, -15, 99, 123, -87, 87, -7, -43, -89, 48, -9, -98, -19, 64, -96, 55, 59, 5, -106, -36, 16, -106, 32, -86, 4, -66, 11, 106, 28, 42, 43, -32, 19, 73, 123, 13, -65, 21, -68, 47, 104, -16, -3, -16, -91, -54, 72, 57, -69, 32, 120, 37, 98, 74, 113, 98, -20, 39};
    private static final String android_id = "9774d56d682e549c";

    private static void init(byte[] arg4) {
        int v0 = 0;
        int v2 = arg4.length;
        while(v0 < v2) {
            int v1 = v0 + 1;
            arg4[v0] = ((byte)(arg4[v0] ^ v1));
            v0 = v1;
        }
    }

    public static void main(String[] args) {
        init(a);
        init(b);

        ByteBuffer v0 = ByteBuffer.allocate(25);
        v0.put((byte) 1);
        v0.putLong(new BigInteger(android_id, 16).longValue());
        v0.putLong(Double.doubleToLongBits(BigDecimal.valueOf(-10000).negate().doubleValue()));
        byte[] v1 = new byte[8];
        new SecureRandom().nextBytes(v1);
        v0.put(v1);
        String v0_1 = new BigInteger(1, v0.array()).modPow(new BigInteger(1, a), new BigInteger(1, b)).toString(16);
        System.out.println("am broadcast -a me.piebridge.brevent.intent.action.ALIPAY --ei me.piebridge.brevent.intent.extra.ALIPAY_COUNT 1 --es me.piebridge.brevent.intent.extra.ALIPAY_SUM \"" + v0_1 + "\"");

        de(v0_1, new BigInteger(1, e));
    }

    public static double de(String arg9, BigInteger arg10) {
        double v0_1;
        int v0 = 1;
        double v2 = 0;
        int v6 = 25;
        if(arg10 == null) {
            v0_1 = v2;
        }
        else {
            byte[] v1 = new BigInteger(arg9, 16).modPow(new BigInteger(1, new byte[]{1, 0, 1}), arg10).toByteArray();
            ByteBuffer v4 = ByteBuffer.allocate(v6);
            if(v1.length == v6) {
                v0 = 0;
            }

            v4.put(v1, v0, v6);
            v4.flip();
            v4.get();
            long v0_2 = v4.getLong();
            if(v0_2 != 0 && v0_2 != new BigInteger(android_id, 16).longValue()) {
                System.out.println("id: " + Long.toHexString(v0_2) + " != " + Long.toHexString(new BigInteger(android_id, 16).longValue()));
                return v2;
            }

            v0_1 = Double.longBitsToDouble(v4.getLong());
        }

        return v0_1;
    }
}
