package FileEncryptionDemo;


import java.io.*;

public class testEncryption implements Encryption {
    private final int KEY = 0x99;

    @Override
    public File encrypted(File f) throws IOException{
        int encBytes;
        File encFile = new File(f.getName().split("\\.")[0]+".enc");
        InputStream inputStream = new FileInputStream(f);
        OutputStream outputStream = new FileOutputStream(encFile);
        while ((encBytes = inputStream.read()) > -1){
            outputStream.write(encBytes ^ KEY);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
        return encFile;
    }

    @Override
    public File decrypted(File f) throws IOException{
        int decBytes;
        File decFile = new File(f.getName().split("\\.")[0]+".mp3");
        InputStream inputStream = new FileInputStream(f);
        OutputStream outputStream = new FileOutputStream(decFile);
        while ((decBytes = inputStream.read()) > -1){
            outputStream.write(decBytes ^ KEY);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
        return decFile;
    }
}
