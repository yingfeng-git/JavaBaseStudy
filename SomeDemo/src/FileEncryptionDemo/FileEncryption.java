package FileEncryptionDemo;

import java.io.*;

public class FileEncryption {
    public String encryptedData(String fileName, Encryption e) throws IOException {
        File baseFile = new File(fileName);
        File encFile = e.encrypted(baseFile);
        return encFile.getName();
    }

    public String declassifyData(String fileName, Encryption e) throws IOException {
        File encFile = new File(fileName);
        File decFile = e.decrypted(encFile);
        return decFile.getName();
    }

    public static void main(String[] args) {
        FileEncryption fe = new FileEncryption();
        testEncryption testEncryption = new testEncryption();
        try{
//            String filename = "C:/Users/yingfeng/IdeaProjects/JavaBaseStudy/SomeDemo/src/FileEncryptionDemo/公敌 - 法老.mp3";
//            String name = fe.encryptedData(filename, testEncryption);
//            System.out.println(name);

            String encName = "C:/Users/yingfeng/IdeaProjects/JavaBaseStudy/公敌 - 法老.enc";
            String name = fe.declassifyData(encName, testEncryption);
            System.out.println(name);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
