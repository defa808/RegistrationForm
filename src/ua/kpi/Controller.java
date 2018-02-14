package ua.kpi;

import java.util.Scanner;
import java.util.Random;

/**
 * Created by Gavriliak on 14.02.2018.
 */

public class Controller {

    private Model model;
    private View view;

    //Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        model.setNumGuess(random.nextInt(100));
        model.setPrevNum(0);
        model.setNextNum(100);

        int num;
        do {
            num = inputOnlyInt(sc);
        }
        while (!checkCorrectNum(num) || !compareNums(num));
    }

    private boolean checkCorrectNum(int num) {
            return num >= model.getPrevNum() && num <= model.getNextNum();
    }

    private boolean compareNums(int num) {
        if (num > model.getNumGuess()) {
            view.printMessage(view.BIG_NUM, num);
            model.setNextNum(num);
            return false;
        }
        if (num < model.getNumGuess()) {
            view.printMessage(view.SMALL_NUM, num);
            model.setPrevNum(num);
            return false;
        }
        if (num == model.getNumGuess())
            view.printMessage(view.SUCCESS);
        return true;
    }

    private int inputOnlyInt(Scanner sc) {
        view.printNumBetweenNums(model.getPrevNum(), model.getNextNum());
        view.printMessage(view.YOUR_INT);

        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_DATA);
            view.printNumBetweenNums(model.getPrevNum(), model.getNextNum());
            view.printMessage(view.YOUR_INT);
            sc.next();
        }
        return sc.nextInt();
    }
}
