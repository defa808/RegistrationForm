package ua.kpi;

/**
 * Created by Gavriliak on 14.02.2018.
 */

public class View {
    public static final String INPUT_INT_DATA = "Input int value from ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String YOUR_INT = "Your num = ";
    public static final String SUCCESS = "GG WP";
    public static final String BIG_NUM = " > my num!";
    public static final String SMALL_NUM = " < my num!";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printNumBetweenNums(int a, int b){
        System.out.println(INPUT_INT_DATA + a + " to " + b);
    }

    public void printMessage(String message, int num){
        System.out.println(num + message);
    }
}
