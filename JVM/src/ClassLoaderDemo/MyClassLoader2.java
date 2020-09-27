package ClassLoaderDemo;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MyClassLoader2 extends ClassLoader {
    /**
     * 破坏双亲委派机制，当需要加载类的时候，先从文件里加载，如果找不到文件才走父加载器加载
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String path = "C:\\Users\\yingfeng\\IdeaProjects\\JavaBaseStudy\\out\\production\\JVM\\";
        String filename = path + name.replace('.', '\\') + ".class"; // 待进一步处理
        File f = new File(filename);
        if(!f.exists()) return super.loadClass(name);
        try {
            InputStream is = new FileInputStream(f);
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.loadClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader2 m = new MyClassLoader2();
        Class<?> cat1 = m.loadClass("pojo.Cat");

        m = new MyClassLoader2();
        Class<?> cat2 = m.loadClass("pojo.Cat");

        m = new MyClassLoader2();
        Class<?> cat3 = m.loadClass("pojo.Cat");

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        System.out.println(cat3.hashCode());
    }
}
