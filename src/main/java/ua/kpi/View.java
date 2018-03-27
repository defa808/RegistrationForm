package ua.kpi;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Gavriliak on 14.02.2018.
 */

public class View {

    // Resource Bundle Installation's
    private static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));  // Ukrainian
                    new Locale("en"));        // English

    // Text's constants
    public static final String INPUT_FULL_NAME = "input.fullname";
    public static final String WRONG_INPUT_FULL_NAME = "input.wrong.fullname";
    public static final String INPUT_NICKNAME = "input.nickname";
    public static final String WROND_INPUT_STRING = "input.wrong.string";
    public static final String INPUT_GROUP = "input.group";
    public static final String WRONG_INPUT_GROUP = "input.wrong.group";
    public static final String INPUT_HOME_NUMBER = "input.home.number";
    public static final String WRONG_INPUT_HOME_NUMBER = "input.wrong.home.number";
    public static final String INPUT_MOBILE_NUMBER = "input.mobile.number";
    public static final String WRONG_INPUT_MOBILE_NUMBER = "input.wrong.mobile.number";
    public static final String INPUT_MOBILE_NUMBER2 = "input.mobile.number2";
    public static final String INPUT_EMAIL = "input.email";
    public static final String WRONG_INPUT__EMAIL = "input.wrong.email";
    public static final String INPUT_SKYPE = "input.skype";
    public static final String INPUT_ADDRESS_INDEX = "input.address.index";
    public static final String WRONG_INPUT_NUMBER = "input.wrong.number";
    public static final String INPUT_CITY_RESIDENCE = "input.address.city.residence";
    public static final String INPUT_STREET = "input.address.street";
    public static final String INPUT_HOUSE_NUMBER = "input.address.house.number";
    public static final String INPUT_APARTMENT_NUMBER = "input.address.apartment.number";
    public static final String INPUT_COMMENT = "input.comment";


    static public void printMessage(String... messages) {
        StringBuilder concatString = new StringBuilder();
        for (String v : messages) {
            concatString = concatString.append(bundle.getString(v));
        }
        String message = new String(concatString);
        System.out.println(message);
    }

    static public String getMessage(String ... messages){
        StringBuilder concatString = new StringBuilder();
        for (String v : messages) {
            concatString = concatString.append(bundle.getString(v));
        }
        String message = new String(concatString);
        return message;
    }
}
