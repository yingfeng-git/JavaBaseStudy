package 面试.xiaomi;

import java.io.IOException;
import java.util.*;

public class Main1 {
    public static boolean match(String s, int a){
        if (s.length() < 2 || s.charAt(0) == ')' ||s.charAt(0) == ']' ||s.charAt(0) == '}') return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char thisChar = s.charAt(i);
            if(thisChar == '(' || thisChar == '{' || thisChar == '['){
                stack.push(s.charAt(i));
            }else if(thisChar == ')'){
                if (stack.poll() != '(') return false;
            }else if(thisChar == '}'){
                if (stack.poll() != '{') return false;
            }else if(thisChar == ']'){
                if (stack.poll() != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean match(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> p = new HashMap<Character, Character>();
        p.put(')', '(');
        p.put('}', '{');
        p.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (p.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != p.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String s = in.nextLine();//读入一行完整的字符串，只在遇见换行符时终止
            if (s == null) {
                System.out.println(true);
            } else {
                System.out.println("他" + match(s));
                System.out.println("我" + match(s, 1));
            }
        }
    }
}
