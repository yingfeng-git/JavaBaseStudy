package ClassicCase.UnionSet;

import java.util.LinkedList;
import java.util.List;

public class Main {
    static class Num{
        int value;
        Num(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }
    public static void main(String[] args) {
        List<Num> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Num(i));
        }

        System.out.println("初始化了一个查并集");
        UnionSet<Num> unionSet = new UnionSet<>(list);
        System.out.println(unionSet);

        System.out.print("看一眼1和2是不是在一个集合里：");
        System.out.println(unionSet.isSameSet(list.get(1), list.get(2)));

        System.out.print("合并1和2，再看一下：");
        unionSet.union(list.get(1), list.get(2));
        System.out.println(unionSet.isSameSet(list.get(1), list.get(2)));

        System.out.println(unionSet);
    }
}
