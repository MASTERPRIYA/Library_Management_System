package models;

import java.util.ArrayList;
import java.sql.*;

public class City {
    private Integer cityId;
    private String name;
//____________________________________________________________________________________________________________ 
    public City(Integer cityId , String name){
        this.cityId = cityId;
        this.name =name;
    }
    public City(Integer cityId){
        this.cityId = cityId;
    }

//____________________________________________________________________________________________________________

public static ArrayList<City> collectAllCities(){
    ArrayList<City> cities = new ArrayList<>();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
        String query = "select * from cities";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cities.add(new City(rs.getInt(1),rs.getString(2)));
        }

        con.close();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    return cities;
}


// ____________________________________________________________________________________________________________
    public Integer getCityId() {
        return cityId;
    }
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
