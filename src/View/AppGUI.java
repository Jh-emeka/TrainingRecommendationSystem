package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppGUI {


    private JFrame firstView;
    private JFrame adminGui;
    private JFrame newSessionView;
    private JFrame recommendationView;

    private JTable traineeTable;
    private JTable sessionsTable;

    private JTabbedPane tabbedPane;
    private JTabbedPane recommendationPane;
    private DefaultTableModel traineeTableModel;
    private DefaultTableModel sessionsTableModel;

    private JPanel tab1;
    private JPanel tab2;
    private JPanel tab3;

    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;




    private JTextField session_Id;
    private JTextField training;
    private JTextField time_Period;
    private JTextField date;
    private JTextField disability_Accommodations;


    private JButton newSession;

    private JButton addNewSession;
    private JButton updateSessionView;
    private JButton updateSession;

    private JButton deleteSession;
    private JButton deleteTrainee;



    private JButton admin;
    private JButton trainee_Reg;





    private JFrame frame;
    private JTextField trainee_Id;
    private JTextField trainee_Name;
    private JTextField highest_education;
    private JTextField age;
    private JTextField gender;
    private JTextField skill;
    private JTextField trainee_time_period;
    private JTextField trainee_disability;
    private JButton register;


    public AppGUI() {


        firstPage();

        registrationForm();

        adminView();

        addNewSession();

       recommendationGui();


    }


    public void firstPage() {

        firstView = new JFrame("Fabrikam Recruitment Company");

        JLabel welcome = new JLabel("Welcome to Fabrikam Recruitment Company !");
        welcome.setFont(new Font("Verdana", Font.BOLD, 20));
        welcome.setBounds(35, 50, 600, 50);
        firstView.add(welcome);


        admin = new JButton("Admin Login");
        admin.setBounds(75, 250, 150, 50);
        firstView.add(admin);

        trainee_Reg = new JButton("Trainee Registration");
        trainee_Reg.setBounds(350, 250, 150, 50);
        firstView.add(trainee_Reg);


        firstView.setLayout(null);
        firstView.setSize(600, 600);
        firstView.setResizable(false);
        firstView.setVisible(true);
        firstView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }

    public void registrationForm() {

        frame = new JFrame("Fabrikam Recruitment Company");


        trainee_Id = new JTextField();


        trainee_Name = new JTextField();
        trainee_Name.setBounds(200, 110, 200, 30);
        frame.add(trainee_Name);

        JLabel name = new JLabel("Name:");
        name.setBounds(150, 110, 100, 20);
        frame.add(name);


        highest_education = new JTextField();
        highest_education.setBounds(200, 150, 200, 30);
        frame.add(highest_education);

        JLabel education = new JLabel("Highest level of Education:");
        education.setBounds(40, 150, 150, 20);
        frame.add(education);

        age = new JTextField();
        age.setBounds(200, 190, 200, 30);
        frame.add(age);

        JLabel age_label = new JLabel("Age:");
        age_label.setBounds(160, 190, 100, 20);
        frame.add(age_label);

        gender = new JTextField();
        gender.setBounds(200, 230, 200, 30);
        frame.add(gender);

        JLabel gender_Label = new JLabel("Gender:");
        gender_Label.setBounds(145, 230, 100, 20);
        frame.add(gender_Label);


        JLabel section = new JLabel("Type in your preferences below:");
        section.setBounds(210, 290, 200, 20);
        frame.add(section);

        skill = new JTextField();
        skill.setBounds(200, 320, 200, 30);
        frame.add(skill);

        JLabel skill_label = new JLabel("Skill to Learn:");
        skill_label.setBounds(120, 320, 100, 20);
        frame.add(skill_label);

        trainee_time_period = new JTextField();
        trainee_time_period.setBounds(200, 370, 200, 30);
        frame.add(trainee_time_period);

        JLabel time = new JLabel("Preferred time period:");
        time.setBounds(70, 370, 200, 20);
        frame.add(time);

        trainee_disability = new JTextField();
        trainee_disability.setBounds(200, 420, 200, 30);
        frame.add(trainee_disability);

        JLabel disability = new JLabel("disability Accommodation:");
        disability.setBounds(45, 420, 200, 20);
        frame.add(disability);


        register = new JButton("Register");
        register.setBounds(240, 470, 120, 30);
        frame.add(register);


        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }


    public void adminView() {

        adminGui = new JFrame("Admin");

        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(5, 5, 810, 1000);

        tab1 = new JPanel();
        tabbedPane.addTab("Trainee", tab1);
        tab1.setLayout(null);
        tab1.setBounds(0, 0, 810, 1000);


        String[] trainee_Column = {"Trainee_Id", "Name", "Highest_Education", "Age", "Gender", "Skill", "Time_Period", "Disability"};

        traineeTableModel = new DefaultTableModel(trainee_Column, 0);
        traineeTable = new JTable(traineeTableModel);
        traineeTable.setBounds(5, 5, 800, 500);
        scrollPane1 = new JScrollPane(traineeTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setBounds(traineeTable.getBounds());

        tab1.add(scrollPane1);


        deleteTrainee = new JButton("Delete Trainee");
        deleteTrainee.setBounds(350, 550, 150, 50);
        tab1.add(deleteTrainee);






        tab2 = new JPanel();
        tabbedPane.addTab("Sessions", tab2);
        tab2.setLayout(null);
        tab2.setBounds(0, 0, 810, 1000);


        String[] column = {"Session_id", "Training", "Time_period", "Date", "Disability_Accommodation"};
        sessionsTableModel = new DefaultTableModel(column, 0);
        sessionsTable = new JTable(sessionsTableModel);
        sessionsTable.setBounds(5, 5, 800, 500);

        scrollPane2 = new JScrollPane(sessionsTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(sessionsTable.getBounds());

        //tab2.add(scrollPane2);

        newSession = new JButton("New Session");
        newSession.setBounds(100, 550, 150, 50);
        tab2.add(newSession);

        updateSessionView = new JButton("update session");
        updateSessionView.setBounds(350, 550, 150, 50);
        tab2.add(updateSessionView);

        deleteSession = new JButton("delete session");
        deleteSession.setBounds(600, 550, 150, 50);
        tab2.add(deleteSession);





        adminGui.add(tabbedPane);

        adminGui.setLayout(null);
        adminGui.setSize(830,800 );
        adminGui.setResizable(false);

        adminGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }

    public void addNewSession() {


        newSessionView = new JFrame("New Session");

        session_Id = new JTextField();


        training = new JTextField();
        training.setBounds(200, 110, 200, 30);
        newSessionView.add(training);

        JLabel trainingLabel = new JLabel("Training:");
        trainingLabel.setBounds(150, 110, 100, 20);
        newSessionView.add(trainingLabel);


        time_Period = new JTextField();
        time_Period.setBounds(200, 150, 200, 30);
        newSessionView.add(time_Period);

        JLabel timePeriodLabel = new JLabel("Time Period:");
        timePeriodLabel.setBounds(128, 150, 150, 20);
        newSessionView.add(timePeriodLabel);

        date = new JTextField();
        date.setBounds(200, 190, 200, 30);
        newSessionView.add(date);

        JLabel date_label = new JLabel("Date:");
        date_label.setBounds(170, 190, 100, 20);
        newSessionView.add(date_label);

        disability_Accommodations = new JTextField();
        disability_Accommodations.setBounds(200, 230, 200, 30);
        newSessionView.add(disability_Accommodations);

        JLabel disability_Label = new JLabel("Disability Accommodation:");
        disability_Label.setBounds(48, 230, 200, 20);
        newSessionView.add(disability_Label);

        addNewSession = new JButton("Add session");
        addNewSession.setBounds(240, 300, 120, 30);
        newSessionView.add(addNewSession);

        updateSession = new JButton("update session");
        updateSession.setBounds(240, 300, 125, 30);
        updateSession.setVisible(false);
        newSessionView.add(updateSession);




//        addNewSession = new JButton("Add session");
//        addNewSession.setBounds(240, 300, 120, 30);
//        newSessionView.add(addNewSession);




//
//        disability_Accommodations = new JTextField();
//


        newSessionView.setLayout(null);
        newSessionView.setSize(600,600);
        newSessionView.setResizable(false);
        newSessionView.setVisible(false);
        newSessionView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }


    public void recommendationGui()
    {


        recommendationView = new JFrame("Recommended sessions");

        recommendationPane = new JTabbedPane();
        recommendationPane.setBounds(5, 5, 810, 1000);

        tab3 = new JPanel();
        recommendationPane.addTab("Recommended Sessions", tab3);
        tab3.setLayout(null);
        tab3.setBounds(0, 0, 810, 1000);




        //tab3.add(scrollPane2);




        recommendationView.add(recommendationPane);
        recommendationView.setLayout(null);
        recommendationView.setSize(830,800 );
        recommendationView.setResizable(false);
        recommendationView.setVisible(false);
        recommendationView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




    }


    public JFrame getFirstView() {
        return firstView;
    }

    public void setFirstView(JFrame firstView) {
        this.firstView = firstView;
    }

    public JButton getAdmin() {
        return admin;
    }

    public void setAdmin(JButton admin) {
        this.admin = admin;
    }

    public JButton getTrainee_Reg() {
        return trainee_Reg;
    }

    public void setTrainee_Reg(JButton trainee_Reg) {
        this.trainee_Reg = trainee_Reg;
    }


    public JTextField getSession_Id() {
        return session_Id;
    }

    public void setSession_Id(JTextField session_Id) {
        this.session_Id = session_Id;
    }

    public JTextField getTraining() {
        return training;
    }

    public void setTraining(JTextField training) {
        this.training = training;
    }

    public JTextField getTime_Period() {
        return time_Period;
    }

    public void setTime_Period(JTextField time_Period) {
        this.time_Period = time_Period;
    }

    public JTextField getDate() {
        return date;
    }

    public void setDate(JTextField date) {
        this.date = date;
    }

    public JTextField getDisability_Accommodations() {
        return disability_Accommodations;
    }

    public void setDisability_Accommodations(JTextField disability_Accommodations) {
        this.disability_Accommodations = disability_Accommodations;
    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getTrainee_Id() {
        return trainee_Id;
    }

    public void setTrainee_Id(JTextField trainee_Id) {
        this.trainee_Id = trainee_Id;
    }

    public JTextField getTrainee_Name() {
        return trainee_Name;
    }

    public void setTrainee_Name(JTextField trainee_Name) {
        this.trainee_Name = trainee_Name;
    }

    public JTextField getHighest_education() {
        return highest_education;
    }

    public void setHighest_education(JTextField highest_education) {
        this.highest_education = highest_education;
    }

    public JTextField getAge() {
        return age;
    }

    public void setAge(JTextField age) {
        this.age = age;
    }

    public JTextField getGender() {
        return gender;
    }

    public void setGender(JTextField gender) {
        this.gender = gender;
    }

    public JTextField getSkill() {
        return skill;
    }

    public void setSkill(JTextField skill) {
        this.skill = skill;
    }

    public JTextField getTrainee_time_period() {
        return trainee_time_period;
    }

    public void setTrainee_time_period(JTextField trainee_time_period) {
        this.trainee_time_period = trainee_time_period;
    }

    public JTextField getTrainee_disability() {
        return trainee_disability;
    }

    public void setTrainee_disability(JTextField trainee_disability) {
        this.trainee_disability = trainee_disability;
    }

    public JFrame getAdminGui() {
        return adminGui;
    }

    public void setAdminGui(JFrame adminGui) {
        this.adminGui = adminGui;
    }

    public JTable getTraineeTable() {
        return traineeTable;
    }

    public void setTraineeTable(JTable traineeTable) {
        this.traineeTable = traineeTable;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public DefaultTableModel getTraineeTableModel() {
        return traineeTableModel;
    }

    public void setTraineeTableModel(DefaultTableModel traineeTableModel) {
        this.traineeTableModel = traineeTableModel;
    }

    public JPanel getTab1() {
        return tab1;
    }

    public void setTab1(JPanel tab1) {
        this.tab1 = tab1;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public void setScrollPane1(JScrollPane scrollPane1) {
        this.scrollPane1 = scrollPane1;
    }


    public JTable getSessionsTable() {
        return sessionsTable;
    }

    public void setSessionsTable(JTable sessionsTable) {
        this.sessionsTable = sessionsTable;
    }

    public DefaultTableModel getSessionsTableModel() {
        return sessionsTableModel;
    }

    public void setSessionsTableModel(DefaultTableModel sessionsTableModel) {
        this.sessionsTableModel = sessionsTableModel;
    }

    public JPanel getTab2() {
        return tab2;
    }

    public void setTab2(JPanel tab2) {
        this.tab2 = tab2;
    }



    public JScrollPane getScrollPane2() {
        return scrollPane2;
    }

    public void setScrollPane2(JScrollPane scrollPane2) {
        this.scrollPane2 = scrollPane2;
    }

    public JFrame getNewSessionView() {
        return newSessionView;
    }

    public void setNewSessionView(JFrame newSessionView) {
        this.newSessionView = newSessionView;
    }

    public JButton getNewSession() {
        return newSession;
    }

    public void setNewSession(JButton newSession) {
        this.newSession = newSession;
    }

    public JButton getAddNewSession() {
        return addNewSession;
    }

    public void setAddNewSession(JButton addNewSession) {
        this.addNewSession = addNewSession;
    }

    public JButton getUpdateSession() {
        return updateSession;
    }

    public void setUpdateSession(JButton updateSession) {
        this.updateSession = updateSession;
    }

    public JButton getDeleteSession() {
        return deleteSession;
    }

    public void setDeleteSession(JButton deleteSession) {
        this.deleteSession = deleteSession;
    }

    public JButton getDeleteTrainee() {
        return deleteTrainee;
    }

    public void setDeleteUser(JButton deleteUser) {
        this.deleteTrainee = deleteUser;
    }

    public JButton getUpdateSessionView() {
        return updateSessionView;
    }

    public void setUpdateSessionView(JButton updateSessionView) {
        this.updateSessionView = updateSessionView;
    }

    public JFrame getRecommendationView() {
        return recommendationView;
    }

    public void setRecommendationView(JFrame recommendationView) {
        this.recommendationView = recommendationView;
    }

    public JTabbedPane getRecommendationPane() {
        return recommendationPane;
    }

    public void setRecommendationPane(JTabbedPane recommendationPane) {
        this.recommendationPane = recommendationPane;
    }

    public JPanel getTab3() {
        return tab3;
    }

    public void setTab3(JPanel tab3) {
        this.tab3 = tab3;
    }

    public void registerBtnActionListener(ActionListener e) {
        register.addActionListener(e);


    }

    public void traineeRegActionListener(ActionListener e) {
        trainee_Reg.addActionListener(e);


    }


    public void adminBtnActionListener(ActionListener e, ActionListener x) {

        admin.addActionListener(e);
        admin.addActionListener(x);

    }

    public void newSessionBtnListener(ActionListener e)
    {

        newSession.addActionListener(e);


    }

    public void addNewSessionBtnListener(ActionListener e) {


        addNewSession.addActionListener(e);


    }

    public void updateViewBtnListener (ActionListener e){


        updateSessionView.addActionListener(e);


    }

    public void deleteSessionBtnListener(ActionListener e){


        deleteSession.addActionListener(e);


    }

    public void deleteTrainee(ActionListener e){


        deleteTrainee.addActionListener(e);


    }


    public void  updateSessionBtnListener(ActionListener e)
    {

        updateSession.addActionListener(e);


    }

    public void deleteTraineeBtnListener(ActionListener e)
    {

        deleteTrainee.addActionListener(e);


    }

    public void sessionsTableMouse()
    {
         sessionsTable.addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {

                 sessionsTable = (JTable) e.getSource();
                 int row = sessionsTable.rowAtPoint(e.getPoint());

                 session_Id.setText(String.valueOf(sessionsTable.getModel().getValueAt(row, 0)));

                 training.setText(String.valueOf(sessionsTable.getModel().getValueAt(row, 1)));

                 time_Period.setText(String.valueOf(sessionsTable.getModel().getValueAt(row, 2)));

                 date.setText(String.valueOf(sessionsTable.getModel().getValueAt(row, 3)));

                 disability_Accommodations.setText(String.valueOf(sessionsTable.getModel().getValueAt(row, 4)));

             }

             @Override
             public void mousePressed(MouseEvent e) {

             }

             @Override
             public void mouseReleased(MouseEvent e) {

             }

             @Override
             public void mouseEntered(MouseEvent e) {

             }

             @Override
             public void mouseExited(MouseEvent e) {

             }
         });





    }



    public void traineeTableMouse()
    {


        traineeTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                traineeTable = (JTable) e.getSource();
                int row = traineeTable.rowAtPoint(e.getPoint());

                trainee_Id.setText(String.valueOf(traineeTable.getModel().getValueAt(row, 0)));



            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



    }

    public static void main(String[] args) {

        AppGUI app = new AppGUI();
    }




}


