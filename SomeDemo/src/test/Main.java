package test;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int round = in.nextInt();
        for (int i = 0; i < round; i++) {

            char[] sisHands = new char[] {in.next().charAt(0), in.next().charAt(0)};
            char[] broHands = new char[] {in.next().charAt(0), in.next().charAt(0)};
            double[] winHands = new double[2];

            for (int i1 = 0; i1 < sisHands.length; i1++) {
                double win = 0;
                for (char broHand : broHands) {
                    if('J' == sisHands[i1] && 'B' == broHand) win++;
                    if('B' == sisHands[i1] && 'S' == broHand) win++;
                    if('S' == sisHands[i1] && 'J' == broHand) win++;
                }
                winHands[i1] = win / 2;
            }
            System.out.println(Arrays.toString(winHands));
            System.out.println(winHands[0] == winHands[1]? "same": winHands[0] > winHands[1]? "left" : "right");

        }
    }
}
