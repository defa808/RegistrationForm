package ua.kpi;

public class Main {

    public static void main(String[] args) {
        Record model = new Record();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}
