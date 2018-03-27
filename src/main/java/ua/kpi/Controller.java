package ua.kpi;


import ua.kpi.Exceptions.DataBaseException;
import ua.kpi.Model.*;

import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gavriliak on 14.02.2018.
 */

public class Controller {

    private Record record;
    private View view;

    private static final String expressionString = "[A-Za-z]{1,15}";
    private static final String expressionFullName = "[A-Za-z]{3,15} [A-Za-z]{3,15} [A-Za-z]{3,15}";
    private static final String expressionHomeNumber = "\\d-\\d{2}-\\d{2}";
    private static final String expressionMobileNumber = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$";
    private static final String expressionEmail = "^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";
    private static final String expressionAddresHomeNumber = "[0-9]+([A-Z])?";
    private static final String expressionAddressIndex = "[0-9]+";

    //Constructor
    public Controller(View view) {
        this.view = view;
    }

    // The Work method
    public void processUser() {

        Scanner sc = new Scanner(System.in);
        Subscriber subscriber = new Subscriber();
        //TODO : overwrite all inputs in more shortcast form
        inputFullName(sc, subscriber);
        subscriber.setNickName(inputStringField(sc, expressionString, View.INPUT_NICKNAME, View.WROND_INPUT_STRING));
        subscriber.setGroup(inputGroupUser(sc));
        subscriber.setHomeNumber(inputStringField(sc, expressionHomeNumber, View.INPUT_HOME_NUMBER, View.WRONG_INPUT_HOME_NUMBER));
        subscriber.setMobileNumber(inputStringField(sc, expressionMobileNumber, View.INPUT_MOBILE_NUMBER, View.WRONG_INPUT_MOBILE_NUMBER));
        subscriber.setMobileNumber2(inputStringFieldWithEmpty(sc, expressionMobileNumber, View.INPUT_MOBILE_NUMBER2, View.WRONG_INPUT_MOBILE_NUMBER));
        subscriber.seteMail(inputStringField(sc, expressionEmail, View.INPUT_EMAIL, View.WRONG_INPUT__EMAIL));
        subscriber.setSkype(inputStringField(sc, expressionString, View.INPUT_SKYPE, View.WROND_INPUT_STRING));
        subscriber.setAddress(inputAddress(sc));

        this.record = new Record(subscriber);

        while (!tryAddRecord()) {
            System.out.println(this.record);
            subscriber.setNickName(inputStringField(sc, expressionString, View.INPUT_NICKNAME, View.WROND_INPUT_STRING));
        }


    }


    private void inputFullName(Scanner sc, Subscriber subscriber) {
        View.printMessage(View.INPUT_FULL_NAME);

        Pattern pattern = Pattern.compile(expressionFullName);
        String input = sc.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            View.printMessage(View.WRONG_INPUT_FULL_NAME);
            input = sc.nextLine();
            matcher = pattern.matcher(input);
        }

        //TODO: rewrite this shit
        String[] fullname = input.split(" ");
        subscriber.setName(fullname[0]);
        subscriber.setSurname(fullname[1]);
        subscriber.setPatronymic(fullname[2]);
    }

    private String inputStringField(Scanner sc, String patternExpression, String stringInput, String stringWrongInput) {
        View.printMessage(stringInput);

        Pattern pattern = Pattern.compile(patternExpression);

        String input = sc.nextLine();

        Matcher matcher = pattern.matcher(input);

        while (!matcher.matches()) {
            View.printMessage(stringWrongInput);
            View.printMessage(stringInput);
            input = sc.nextLine();
            matcher = pattern.matcher(input);
        }
        return input;
    }

    private String inputStringFieldWithEmpty(Scanner sc, String patternExpression, String stringInput, String stringWrongInput) {
        View.printMessage(stringInput);

        Pattern pattern = Pattern.compile(patternExpression);

        String input = sc.nextLine();
        System.out.println(input);
        Matcher matcher = pattern.matcher(input);

        while ((!matcher.matches()) && !input.isEmpty()) {
            View.printMessage(stringWrongInput);
            View.printMessage(stringInput);
            input = sc.nextLine();
            matcher = pattern.matcher(input);
        }
        return input;
    }


    private GroupSubscriber inputGroupUser(Scanner sc) {
        View.printMessage(View.INPUT_GROUP);
        while (true) {
            switch (sc.nextInt()) {
                case 1:
                    return GroupSubscriber.USER;
                case 2:
                    return GroupSubscriber.ADMIN;
            }
            View.printMessage(View.WRONG_INPUT_GROUP);
        }
    }

    private Address inputAddress(Scanner sc) {
        String index = inputStringField(sc, expressionAddressIndex, View.INPUT_ADDRESS_INDEX, View.WRONG_INPUT_NUMBER);
        String cityOfResidence = inputStringField(sc, expressionString, View.INPUT_CITY_RESIDENCE, View.WROND_INPUT_STRING);
        String street = inputStringField(sc, expressionString, View.INPUT_STREET, View.WROND_INPUT_STRING);
        String houseNumber = inputStringField(sc, expressionAddresHomeNumber, View.INPUT_HOUSE_NUMBER, View.WRONG_INPUT_NUMBER);
        String apartmentNumber = inputStringField(sc, expressionAddressIndex, View.INPUT_APARTMENT_NUMBER, View.WRONG_INPUT_NUMBER);

        return new Address(index, cityOfResidence, street, houseNumber, apartmentNumber);
    }

    private boolean tryAddRecord() {
        try {
            Record.addRecord(this.record);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e);
            return false;

        } catch (DataBaseException e) {
            System.out.println(e);
            return false;

        }
    }


}

