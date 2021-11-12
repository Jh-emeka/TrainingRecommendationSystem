package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TraineeDB_functions {


    public List<Trainee> getAll()
    {

        ArrayList<Trainee> trainee = new ArrayList<>();

        String read = "SELECT * FROM Trainee ";
        try (Connection connect = ConnectionClass.getConnection();
             PreparedStatement prep = connect.prepareStatement(read)) {

            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {

                trainee.add(Trainee.newResultSet(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.TraineeDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }


      return trainee;

    }


    public void addTrainee(Trainee trainee)
    {


        String create = "INSERT INTO Trainee (Name, Highest_Education, Age, Gender, Skill, Time_period, Disability)" + "VALUES(?,?,?,?,?,?,?)";
        try (Connection connect = ConnectionClass.getConnection(); // auto close the connection object after try
             PreparedStatement prep = connect.prepareStatement(create)) {


            prep.setString(1, trainee.getName());
            prep.setString(2, trainee.getHighest_Education());
            prep.setInt(3, trainee.getAge());
            prep.setString(4, trainee.getGender());
            prep.setString(5, trainee.getSkill());
            prep.setString(6, trainee.getTime());
            prep.setString(7, trainee.getDisability());


            prep.execute();

        } catch (SQLException ex) {
            Logger.getLogger(TraineeDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void deleteTrainee(Trainee trainee)
    {
        String delete = "DELETE FROM Trainee WHERE Trainee_id = ?";
        try (Connection connect = ConnectionClass.getConnection(); // auto close the connection object after try
             PreparedStatement prep = connect.prepareStatement(delete)) {


            prep.setInt(1, trainee.getTrainee_Id());
            prep.execute();

        } catch (SQLException ex) {
            Logger.getLogger(TraineeDB_functions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



}
