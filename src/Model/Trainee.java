package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Trainee {

    private int trainee_Id;

    private String name;

    private String highest_Education;

    private int age;

    private String gender;

    public Trainee(int trainee_Id, String name, String highest_Education, int age, String gender, String skill, String time, String disability) {
        this.trainee_Id = trainee_Id;
        this.name = name;
        this.highest_Education = highest_Education;
        this.age = age;
        this.gender = gender;
        this.skill = skill;
        this.time = time;
        this.disability = disability;
    }

    private String skill;

    private String time;

    private String disability;




    public Trainee() {

    }


    public static Trainee newResultSet(ResultSet resultSet) throws SQLException {

        return new Trainee(

                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getString(7),
                resultSet.getString(8)

        );

    }


    public int getTrainee_Id() {
        return trainee_Id;
    }

    public void setTrainee_Id(int trainee_Id) {
        this.trainee_Id = trainee_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHighest_Education() {
        return highest_Education;
    }

    public void setHighest_Education(String highest_Education) {
        this.highest_Education = highest_Education;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }
}



