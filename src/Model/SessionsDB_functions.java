package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionsDB_functions {


    public List<Sessions> getAll()
    {

        ArrayList<Sessions> session = new ArrayList<>();

        String read = "SELECT * FROM Sessions";
        try (Connection connect = ConnectionClass.getConnection();
             PreparedStatement prep = connect.prepareStatement(read)) {

            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {


                session.add(Sessions.newSessionsResultSet(resultSet));


            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.SessionsDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }


        return session;

    }



    public void addSession(Sessions session)
    {

        String create = "INSERT INTO Sessions (Training, Time_Period, Date, Disability_Accommodations)" + "VALUES(?,?,?,?)";
        try (Connection connect = ConnectionClass.getConnection(); // auto close the connection object after try
             PreparedStatement prep = connect.prepareStatement(create)) {


            prep.setString(1, session.getTraining());
            prep.setString(2, session.getTime_Period());
            prep.setString(3, session.getDate());
            prep.setString(4, session.getDisabilityAccommodation());

            prep.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SessionsDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void updateSession(Sessions session)
    {

        String update = "UPDATE Sessions SET Training = ?, Time_Period = ?, Date = ?, Disability_Accommodations = ?" + "WHERE Session_id = ?";
        try (Connection connect = ConnectionClass.getConnection(); // auto close the connection object after try
             PreparedStatement prep = connect.prepareStatement(update)) {


            prep.setString(1, session.getTraining());
            prep.setString(2, session.getTime_Period());
            prep.setString(3, session.getDate());
            prep.setString(4, session.getDisabilityAccommodation());
            prep.setInt(5,session.getSession_Id());
            prep.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SessionsDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }


    }



    public void deleteSession(Sessions session)
    {

        String delete = "DELETE FROM Sessions WHERE Session_id = ?";
        try (Connection connect = ConnectionClass.getConnection(); // auto close the connection object after try
             PreparedStatement prep = connect.prepareStatement(delete)) {

            prep.setInt(1,session.getSession_Id());
            prep.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SessionsDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }


    }





    public List<Sessions> recommendSession(Trainee trainee)
    {
        ArrayList<Sessions> sessionRecommend = new ArrayList<>();

       String recommend = "SELECT * FROM Sessions WHERE Training LIKE '%" + trainee.getSkill() + "%' AND  Time_Period LIKE '%" + trainee.getTime() + "%' AND Disability_Accommodations LIKE '%" + trainee.getDisability() + "%' " ;

        try (Connection connect = ConnectionClass.getConnection(); // auto close the connection object after try
             PreparedStatement prep = connect.prepareStatement(recommend)) {

            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {

                sessionRecommend.add(Sessions.newSessionsResultSet(resultSet));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionsDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(trainee.getSkill());

        return  sessionRecommend;

    }




}
