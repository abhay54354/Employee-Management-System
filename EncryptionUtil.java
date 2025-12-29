public class EncryptionUtil {


// simple Caesar-style encryption (industry-level nahi, but logic correct)
public static String encrypt(String data) {
StringBuilder sb = new StringBuilder();
for (char c : data.toCharArray()) {
sb.append((char) (c + 3));
}
return sb.toString();
}


public static String decrypt(String data) {
StringBuilder sb = new StringBuilder();
for (char c : data.toCharArray()) {
sb.append((char) (c - 3));
}
return sb.toString();
}
}
