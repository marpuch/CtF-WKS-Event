package victim.priv.logic;


public class CryptoUtil {

    public static byte[] hex2byte(String str) {
        String[] split = str.split("(?<=\\G..)");
        byte[] result = new byte[split.length];
        int i = 0;
        for (String b : split) {
            result[i++] = (byte)Integer.parseInt(b, 16);
        }
        return result;
    }
    
    public static String bytes2hex(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (byte oneByte : b) {
            sb.append(byte2hex(oneByte));
        }
        return sb.toString();
    }
    
    public static String byte2hex(byte b) {
        return String.format("%02X", b).toLowerCase();
    }
    
    public static String byte2bin(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
}
