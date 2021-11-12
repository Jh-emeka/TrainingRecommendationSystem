package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sessions {

    private int session_Id;
    private String training;
    private String time_Period;
    private String date;
    private String disabilityAccommodation;


    public Sessions(int session_Id, String training, String time_Period, String date, String disabilityAccommodation) {
        this.session_Id = session_Id;
        this.training = training;
        this.time_Period = time_Period;
        this.date = date;
        this.disabilityAccommodation = disabilityAccommodation;
    }

    public Sessions() {

    }


    public static Sessions newSessionsResultSet(ResultSet resultSet) throws SQLException {


        return  new Sessions(

                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5)

        );


    }



    public int getSession_Id() {
        return session_Id;
    }

    public void setSession_Id(int session_Id) {
        this.session_Id = session_Id;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getTime_Period() {
        return time_Period;
    }

    public void setTime_Period(String time_Period) {
        this.time_Period = time_Period;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisabilityAccommodation() {
        return disabilityAccommodation;
    }

    public void setDisabilityAccommodation(String disabilityAccommodation) {
        this.disabilityAccommodation = disabilityAccommodation;
    }
}
