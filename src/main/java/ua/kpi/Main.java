package ua.kpi;

import ua.kpi.Model.Record;
/**
 * Created by Gavriliak on 14.02.2018.
 */
public class Main {
    static View view = new View();
    public static void main(String[] args) {

//        Record record = new Record();
        Controller controller = new Controller(view);
        // Run
        controller.processUser();
        controller.processUser();
    }
}
