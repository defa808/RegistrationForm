package ua.kpi;


import ua.kpi.Model.Address;
import ua.kpi.Model.GroupSubscriber;
import ua.kpi.Model.Record;
import ua.kpi.Model.Subscriber;

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

        inputFullName(sc, subscriber);
        subscriber.setNickName(inputStringField(sc, expressionString, view.INPUT_NICKNAME, view.WROND_INPUT_STRING));
        subscriber.setGroup(inputGroupUser(sc));
        subscriber.setHomeNumber(inputStringField(sc, expressionHomeNumber, view.INPUT_HOME_NUMBER, view.WRONG_INPUT_HOME_NUMBER));
        subscriber.setMobileNumber(inputStringField(sc, expressionMobileNumber, view.INPUT_MOBILE_NUMBER, view.WRONG_INPUT_MOBILE_NUMBER));
        subscriber.setMobileNumber2(inputStringFieldWithEmpty(sc, expressionMobileNumber, view.INPUT_MOBILE_NUMBER2, view.WRONG_INPUT_MOBILE_NUMBER));
        subscriber.seteMail(inputStringField(sc, expressionEmail, view.INPUT_EMAIL, view.WRONG_INPUT__EMAIL));
        subscriber.setSkype(inputStringField(sc, expressionString, view.INPUT_SKYPE, view.WROND_INPUT_STRING));
        subscriber.setAddress(inputAddress(sc));

        view.printMessage(View.INPUT_COMMENT);
        String comment = sc.nextLine();


        this.record = new Record(subscriber, comment);
    }

    private void inputFullName(Scanner sc, Subscriber subscriber) {
        view.printMessage(view.INPUT_FULL_NAME);

        Pattern pattern = Pattern.compile("[A-Za-z]{3,15} [A-Za-z]{3,15} [A-Za-z]{3,15}");

        String input = sc.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            view.printMessage(view.WRONG_INPUT_FULL_NAME);
            input = sc.nextLine();
            matcher = pattern.matcher(input);
        }

        String[] fullname = input.split(" ");
        subscriber.setName(fullname[0]);
        subscriber.setSurname(fullname[1]);
        subscriber.setPatronymic(fullname[2]);
    }

    private String inputStringField(Scanner sc, String patternExpression, String stringInput, String stringWrongInput) {
        view.printMessage(stringInput);

        Pattern pattern = Pattern.compile(patternExpression);

        String input = sc.nextLine();

        Matcher matcher = pattern.matcher(input);

        while (!matcher.matches()) {
            view.printMessage(stringWrongInput);
            view.printMessage(stringInput);
            input = sc.nextLine();
            matcher = pattern.matcher(input);
        }
        return input;
    }

    private String inputStringFieldWithEmpty(Scanner sc, String patternExpression, String stringInput, String stringWrongInput) {
        view.printMessage(stringInput);

        Pattern pattern = Pattern.compile(patternExpression);

        String input = sc.nextLine();
        System.out.println(input);
        Matcher matcher = pattern.matcher(input);

        while ((!matcher.matches()) && !input.isEmpty()) {
            view.printMessage(stringWrongInput);
            view.printMessage(stringInput);
            input = sc.nextLine();
            matcher = pattern.matcher(input);
        }
        return input;
    }


    private GroupSubscriber inputGroupUser(Scanner sc) {
        view.printMessage(view.INPUT_GROUP);
        while (true) {
            switch (sc.nextInt()) {
                case 1:
                    return GroupSubscriber.USER;
                case 2:
                    return GroupSubscriber.ADMIN;
            }
            view.printMessage(view.WRONG_INPUT_GROUP);
        }
    }

    private Address inputAddress(Scanner sc) {
        String index = inputStringField(sc, expressionAddressIndex, view.INPUT_ADDRESS_INDEX, view.WRONG_INPUT_NUMBER);
        String cityOfResidence = inputStringField(sc, expressionString, view.INPUT_CITY_RESIDENCE, view.WROND_INPUT_STRING);
        String street = inputStringField(sc, expressionString, view.INPUT_STREET, view.WROND_INPUT_STRING);
        String houseNumber = inputStringField(sc, expressionAddresHomeNumber, view.INPUT_HOUSE_NUMBER, view.WRONG_INPUT_NUMBER);
        String apartmentNumber = inputStringField(sc, expressionString, view.INPUT_APARTMENT_NUMBER, view.WRONG_INPUT_NUMBER);

        return new Address(index, cityOfResidence, street, houseNumber, apartmentNumber);
    }
}
