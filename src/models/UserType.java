package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//________________________________________________________________________________________________________
public class UserType {
    private Integer userTypeId;
    private String name;


//_______________________________________________________________________________________________________ 

    public static final UserType Library = new UserType(1, "Library");
    public static final UserType Librarian = new UserType(2, "Librarian");
    public static final UserType Candidate = new UserType(3, "Candidate");
    public static final UserType Publisher = new UserType(4, "Publisher");

//_________________________________________________________________________________________________________
    public UserType(Integer userTypeId){
        this.userTypeId=userTypeId;
    }

    public UserType(Integer userTypeId ,String name){
        this.userTypeId = userTypeId;
        this.name = name;
    }
//__________________________________________________________________________________________________________

public static ArrayList<UserType> collectAllUserTypes(){
    ArrayList<UserType> userTypes = new ArrayList<>();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
        String query = "select * from user_types";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            userTypes.add(new UserType(rs.getInt(1),rs.getString(2)));   
        }
        con.close();

    } catch (SQLException | ClassNotFoundException e){
       e.printStackTrace();
    }
    return userTypes;
}

//__________________________________________________________________________________________________________
    public Integer getUserTypeId(){
        return userTypeId;
    }
    public void setUserTypeId(Integer userTypeId){
        this.userTypeId = userTypeId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
}
