package models;

import java.sql.*;
import java.util.ArrayList;

public class Librarian extends User {
    private Integer librarianId;
    private String adhaarcard;
    private String about;
    private String qualification;
    private Integer experience;


//-------------------------------------------------------------------------------------------------------------
    public Librarian(String name,UserType userType,String email,City city,String password,String phone,String adhaarcard,String qualification ,Integer experience,String about){
        super(name, userType, email, city, password, phone);
        this.adhaarcard=adhaarcard;
        this.qualification=qualification;
        this.experience=experience;
        this.about=about;
        
    }
    public Librarian(String email,String password) {
        super(email, password);
    }

    public Librarian(){
        
    }
//-------------------------------------------------------------------------------------------------------------------------------------
public int signInLibrarian(){
    int statusId =0;
    //0 = account with email not exist.
    //1 = all ok.
    //2 = inactive.
    //3= closed.
    //4= blocked.
    //5= pending

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
        String query = "select u.password,u.user_id,u.name,email,phone,address,c.city_id,c.name,s.status_id,t.userType_id,l.librarian_id,adhaarcard,about,qualification,experience"
        +" from users as u inner join cities as c inner join status as s inner join user_Types as t inner join librarians as l where u.city_id = c.city_id and u.status_id = s.status_id"
        +" and u.userType_id = t.userType_id and u.user_id=l.user_id and email=?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, getEmail());
    
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            String pwd = rs.getString("password");
            System.out.println(pwd+"_________________Pwd");
            boolean passwordMatch = getPassword().equals(pwd);
            System.out.println(passwordMatch);
            if(passwordMatch){
                System.out.println("______________passwordMatch________________________________");
                statusId = rs.getInt("status_id");
                System.out.println(statusId+":::::::::::::::::::::::::::::::StatusId of Librarian");
                if(statusId==1) {
                        setUserId(rs.getInt("user_id"));
                        setName(rs.getString("name"));
                        setEmail(rs.getString("email"));
                        setPhone(rs.getString("phone"));
                        setAddress(rs.getString("address"));
                        setCity(new City(rs.getInt("city_id"),rs.getString("name")));
                        setUserType(new UserType(rs.getInt("userType_id")));
                        librarianId =rs.getInt("librarian_id");
                        adhaarcard = rs.getString("adhaarcard");
                        about=rs.getString("about");
                        qualification = rs.getString("qualification");
                        experience = rs.getInt("experience");
                }else{
                        statusId = -1;
                }
            }
        }
    con.close();
    } catch (SQLException |ClassNotFoundException e) {
        e.printStackTrace();
    }
    return statusId;
}
//------------------------------------------------------------------------------------------------------------
    public boolean signUpLibrarian(){
        boolean flag=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query ="insert into librarians (user_id,adhaarcard,qualification,experience,about) value (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,getUserId());
            ps.setString(2,adhaarcard);
            ps.setString(3,qualification);
            ps.setInt(4,experience);
            ps.setString(5,about);
            System.out.println(ps);
            int count = ps.executeUpdate();
            if(count==1){
                flag=true;
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    public void getDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select librarian_id,adhaarcard,about,qualification,experience,u.user_id,u.name,email,c.city_id," +
            "password,phone,ut.userType_id from librarians as l inner join users as u inner join user_Types as ut"+
            " inner join cities as c where l.user_id=u.user_id and u.userType_id=ut.userType_id and u.city_id = c.city_id and u.userType_id=2 and librarian_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println(ps);
            ps.setInt(1,librarianId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                librarianId = rs.getInt(1);
                adhaarcard = rs.getString(2);
                about = rs.getString(3);
                qualification = rs.getString(4);
                experience = rs.getInt(5);
                setUserId(rs.getInt(6));
                setName(rs.getString(7));
                setEmail(rs.getString(8));
                setCity(new City(rs.getInt(9)));
                setPassword(rs.getString(10));
                setPhone(rs.getString(11));
                
            }

            con.close();
    
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //------------------------------------------------------------------------------------------------------------- 
    public static ArrayList<Librarian> collectAllLibrarians(Integer userTypeId){
        ArrayList<Librarian> librarians = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select librarian_id,adhaarcard,about,qualification,experience,u.user_id,u.name,email,c.city_id," +
            "password,phone,ut.userType_id from librarians as l inner join users as u inner join user_Types as ut"+
            " inner join cities as c where l.user_id=u.user_id and u.userType_id=ut.userType_id and u.city_id = c.city_id and u.userType_id=2";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println(ps);
            //ps.setInt(1,userTypeId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Librarian librarian = new Librarian();
                librarian.librarianId = rs.getInt(1);
                librarian.adhaarcard = rs.getString(2);
                librarian.about = rs.getString(3);
                librarian.qualification = rs.getString(4);
                librarian.experience = rs.getInt(5);
                librarian.setUserId(rs.getInt(6));
                librarian.setName(rs.getString(7));
                librarian.setEmail(rs.getString(8));
                librarian.setCity(new City(rs.getInt(9)));
                librarian.setPassword(rs.getString(10));
                librarian.setPhone(rs.getString(11));
                librarians.add(librarian);
            }

            con.close();
    
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return librarians;
    }

    //-------------------------------------------------------------------------------------------------------------   

    public Integer getLibrarianId() {
        return librarianId;
    }
    public void setLibrarianId(Integer librarianId) {
        this.librarianId = librarianId;
    }

    public String getAdhaarcard() {
        return adhaarcard;
    }
    public void setAdhaarcard(String adhaarcard) {
        this.adhaarcard = adhaarcard;
    }

    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }

    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    // public Library getLibrary() {
    //     return library;
    // }
    // public void setLibrary(Library library) {
    //     this.library = library;
    // }

}
