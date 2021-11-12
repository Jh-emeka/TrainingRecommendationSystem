import Model.TraineeDB_functions;
import Model.Trainee;
import View.AppGUI;
import Model.Sessions;
import Model.SessionsDB_functions;

import Controller.AppController;

public class App {

    public static void main(String[] args) {

        TraineeDB_functions functions = new TraineeDB_functions();

        Trainee trainee = new Trainee();

        AppGUI view = new AppGUI();

        Sessions session = new Sessions();

        SessionsDB_functions session_DbFunctions = new SessionsDB_functions();


        AppController controller = new AppController(view, trainee, functions, session,session_DbFunctions);

        controller.initAppController();







    }

}
