package FileEncryptionDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Encryption {
    File encrypted(File f) throws IOException;
    File decrypted(File f) throws IOException;
}
