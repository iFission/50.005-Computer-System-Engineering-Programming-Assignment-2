import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.security.spec.*;

class PrivateKeyReader {

    static PrivateKey get(String filename) throws Exception {

        byte[] keyBytes = Files.readAllBytes(Paths.get(filename));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}