//import java.util.HashMap;
//
//public class HashMapReplaceDemo {
//    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, 21);
//        map.put(11, 211);
//        map.put(111, 2111);
//        map.put(1111, 21111);
//        map.put(11111, 211111);
//        map.put(111111, 2111111);
//
//        map.forEach((k, v) -> {
//            System.out.println(k + " "+ v);
//        });
//
//        map.replaceAll((k, v) -> {
//            if (v == 211) {
//                return 1231231;
//            }
//            return v;
//        });
//
//
//        map.computeIfAbsent(123, (k) ->{
//            System.out.println("给" + k + "一个123");
//            return 123;
//        });
//        System.out.println(map);
//    }
//}
