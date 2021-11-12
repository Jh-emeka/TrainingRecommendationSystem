package Controller;


import Model.TraineeDB_functions;
import Model.Trainee;
import Model.Sessions;
import Model.SessionsDB_functions;
import View.AppGUI;
import java.util.ArrayList;


public class AppController {

    private final AppGUI view;
    private final Trainee trainee;
    private final TraineeDB_functions traineeDB_functions;
    private final Sessions sessions;
    private final SessionsDB_functions session_DbFunctions;



    public AppController(AppGUI view, Trainee trainee, TraineeDB_functions traineeDB_functions, Sessions sessions, SessionsDB_functions session_DbFunctions) {
        this.view = view;
        this.trainee = trainee;
        this.traineeDB_functions = traineeDB_functions;
        this.sessions = sessions;
        this.session_DbFunctions = session_DbFunctions;



    }

    public void initAppController() { // initialising all the action listeners from the view class.
        view.registerBtnActionListener(e -> newTrainee());

        view.traineeRegActionListener(e -> getRegForm());

        view.adminBtnActionListener(e -> fillTraineeTable(),e -> fillSessionsTable());

        view.newSessionBtnListener(e -> getNewSessionForm());

        view.addNewSessionBtnListener(e -> addNewSession());

        view.updateViewBtnListener(e -> getUpdateView());

        view.sessionsTableMouse();

        view.traineeTableMouse();

        view.updateSessionBtnListener(e -> updateSession());

        view.deleteSessionBtnListener(e -> deleteSession());

        view.deleteTraineeBtnListener(e -> deleteRegistration());

    }

    private void getRegForm() { // brings up the form for registering new trainees


        view.getFrame().setVisible(true);

    }

    private void getNewSessionForm(){ // pops up the form for adding a new session
       view.getUpdateSession().setVisible(false);
       view.getAddNewSession().setVisible(true);
       view.getNewSessionView().setVisible(true);

    }


    private void newTrainee() { // setting the trainee object with data from the view text fields

        trainee.setName(view.getTrainee_Name().getText());
        trainee.setHighest_Education(view.getHighest_education().getText());
        trainee.setAge(Integer.parseInt(view.getAge().getText()));
        trainee.setGender(view.getGender().getText());
        trainee.setSkill(view.getSkill().getText());
        trainee.setTime(view.getTrainee_time_period().getText());
        trainee.setDisability(view.getTrainee_disability().getText());

        traineeDB_functions.addTrainee(trainee);

        getRecommendations();


    }



    private void fillTraineeTable() // fill the trainee table in the view with data from the database
    {

        view.getAdminGui().setVisible(true);

        ArrayList<Trainee> traineeList  = (ArrayList<Trainee>) traineeDB_functions.getAll();

        view.getTraineeTableModel().setRowCount(0);

        for(Trainee trainee : traineeList)
        {

            int trainee_Id = trainee.getTrainee_Id();

            String name = trainee.getName();

            String highest_education = trainee.getHighest_Education();

            int age = trainee.getAge();

            String gender = trainee.getGender();

            String skill = trainee.getSkill();

            String time_Period = trainee.getTime();

            String disability = trainee.getDisability();

            Object[] data = {trainee_Id, name, highest_education, age, gender, skill, time_Period, disability};

           view.getTraineeTableModel().addRow(data);


        }

    }


    private void fillSessionsTable() { // fill the Sessions table in the view with data from the database

         view.getSessionsTableModel().setRowCount(0);

        for (Sessions sessions : session_DbFunctions.getAll()) {

            int session_Id = sessions.getSession_Id();
            String training = sessions.getTraining();
            String time_Period = sessions.getTime_Period();
            String date = sessions.getDate();
            String disability = sessions.getDisabilityAccommodation();

            Object[] row = {session_Id,training,time_Period,date,disability};

            view.getSessionsTableModel().addRow(row);

        }

        view.getTab2().add(view.getScrollPane2());


    }

    private void fillRecommendedTable() // fills the recommended sessions table with data from the database
    {
        view.getSessionsTableModel().setRowCount(0);

        for (Sessions sessions : session_DbFunctions.recommendSession(trainee)) {

            int session_Id = sessions.getSession_Id();
            String training = sessions.getTraining();
            String time_Period = sessions.getTime_Period();
            String date = sessions.getDate();
            String disability = sessions.getDisabilityAccommodation();

            Object[] row = {session_Id,training,time_Period,date,disability};

            view.getSessionsTableModel().addRow(row);

        }

        view.getTab3().add(view.getScrollPane2());

    }


    private void addNewSession() // setting the Session object with data from the view text fields
    {

        sessions.setTraining(view.getTraining().getText());
        sessions.setTime_Period(view.getTime_Period().getText());
        sessions.setDate(view.getDate().getText());
        sessions.setDisabilityAccommodation(view.getDisability_Accommodations().getText());


        session_DbFunctions.addSession(sessions);

        fillSessionsTable();

    }

    private void getUpdateView() // brings up the form for updating sessions
    {



        view.getNewSessionView().setVisible(true);

        view.getAddNewSession().setVisible(false);

        view.getUpdateSession().setVisible(true);






    }









    private void updateSession()
    {


        sessions.setSession_Id(Integer.parseInt(view.getSession_Id().getText()));
        sessions.setTraining(view.getTraining().getText());
        sessions.setTime_Period(view.getTime_Period().getText());
        sessions.setDate(view.getDate().getText());
        sessions.setDisabilityAccommodation(view.getDisability_Accommodations().getText());

        session_DbFunctions.updateSession(sessions);

        fillSessionsTable();



    }

    private void deleteSession()
    {



        sessions.setSession_Id(Integer.parseInt(view.getSession_Id().getText()));

        session_DbFunctions.deleteSession(sessions);

        fillSessionsTable();


    }

    private void deleteRegistration()
    {

        trainee.setTrainee_Id(Integer.parseInt(view.getTrainee_Id().getText()));

        traineeDB_functions.deleteTrainee(trainee);

        fillTraineeTable();

    }

    private void getRecommendations()
    {
        view.getRecommendationView().setVisible(true);
        fillRecommendedTable();




    }



}
