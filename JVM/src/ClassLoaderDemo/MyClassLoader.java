package ClassLoaderDemo;

import pojo.Cat;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private static byte[] readClass(String name) throws IOException{
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(new File(name));
            baos = new ByteArrayOutputStream();

            int i;
            while ((i = fis.read()) != -1) {
                baos.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(baos != null){
                baos.close();
            }
            if(fis != null) {
                fis.close();
            }
        }
        return baos.toByteArray();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 输入类的位置，把类文件读取进来，并转换成byte[]
        String path = "C:\\Users\\yingfeng\\IdeaProjects\\JavaBaseStudy\\out\\production\\JVM\\";
        String filename = path + name.replace('.', '\\') + ".class"; // 待进一步处理

        byte[] classData = new byte[0];
        try {
            classData = readClass(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, classData, 0, classData.length);
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.loadClass("pojo.Cat");
        Cat cat1 = (Cat) clazz.newInstance();
        Cat cat2 = new Cat();

        cat1.run();
        cat2.run();

        System.out.println(cat1.getClass());
        System.out.println(cat2.getClass());



    }
}
