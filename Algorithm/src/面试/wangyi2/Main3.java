package 面试.wangyi2;
import java.util.*;

public class Main3{
    static int fd = 0;
    static HashMap<Integer, List<String>> fileSys = new HashMap<>();

    public static void open_(String filename){
        List<String> list = new LinkedList<>();
        list.add(filename);
        fileSys.put(fd, list);
        System.out.println(fd);
        fd++;
    }

    public static void dup_(int fd_){
        fileSys.put(fd, fileSys.get(fd_));
        System.out.println(fd);
        fd++;
    }

    public static void dup2_(int fd_, int newFd) {
        if (fileSys.containsKey(newFd)) {
            fileSys.get(newFd).addAll(fileSys.get(fd_));
        } else {
            fileSys.put(newFd, fileSys.get(fd_));
        }
    }

    public static void close_(int fd_){
        fileSys.put(fd_, null);
    }

    public static void query_(int fd_){
        List<String> list = fileSys.get(fd_);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int groups = in.nextInt();
        for (int group = 0; group < groups; group++) {
            int orders = in.nextInt();
            for (int order = 0; order < orders; order++) {
                String method = in.next();
                if("open".equals(method)){
                    open_(in.next());
                }else if("dup".equals(method)){
                    dup_(in.nextInt());
                }else if("dup2".equals(method)){
                    dup2_(in.nextInt(), in.nextInt());
                }else if("close".equals(method)){
                    close_(in.nextInt());
                }else if("query".equals(method)){
                    query_(in.nextInt());
                }
            }
        }
        fd = 0;
        fileSys.clear();
    }
}