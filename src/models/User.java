package models;
import java.sql.*;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User{
    static StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
    
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String pic;
    private String address;
    private City city;
    private String otp;
    private Status status;
    private UserType userType;

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public User(){
        
    }

    public User(String email,String password) {
        this.email = email;
        this.password =password;
    }

    public User(String name, String email, String password, String phone , City city ,UserType userType ,String otp){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.city = city;
        this.userType = userType;
        this.otp=otp;
    }

    public User(String name,UserType userType,String email,City city,String password,String phone){
        this.name= name;
        this.userType=userType;
        this.email=email;
        this.city= city;
        this.password=password;
        this.phone=phone;
    }
    
    public User(String name, String email, String password, City city, UserType userType, String phone, String address, String otp) {
       this.name=name;
       this.email=email;
       this.password=password;
       this.city=city;
       this.userType=userType;
      this.phone=phone;
      this.address=address;
      this.otp=otp;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public boolean signUpUserCandidate(){
        boolean flag= false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "insert into users (name,email,password,city_id,userType_id,phone,address,otp) value (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setInt(4, city.getCityId());
            ps.setInt(5, userType.getUserTypeId());
            ps.setString(6,phone);
            ps.setString(7, address);
            ps.setString(8, otp);
            System.out.println(ps+"-----------------------------------signUpUserCandidate------------------------------------");
            int count= ps.executeUpdate();
            if(count==1){
                flag=true;
                ResultSet rs= ps.getGeneratedKeys();
                if(rs.next()){
                    userId=rs.getInt(1);
                }
            }
            con.close();
        } catch (SQLException|ClassNotFoundException e) {
           e.printStackTrace();
        }
        return flag;
    }
//__________________________________________________________________________________________________________________________________________________
    public static void changePassword(String email,String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "update users set password=? where email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println(ps);
            con.close();
        } catch (SQLException|ClassNotFoundException e) {
           e.printStackTrace();
        }
    }  
    //____________________________________________________________________________________________________________________________________   
        public void savePic(String fileName){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");

                String query = "update users set pic=? and user_id=? where userType_id=3";
                PreparedStatement ps = con.prepareStatement(query);
                System.out.println(ps);

                ps.setString(1,email+"/"+fileName);
                ps.setInt(2,userId);
                int count = ps.executeUpdate();

                if(count == 1){
                    this.pic = email+"/"+fileName;
                    System.out.println("*****************************");
                }

                con.close();

            } catch (SQLException|ClassNotFoundException e) {
                e.printStackTrace();
            }
        }    
    //_________________________________________________________________________________________________________________    
    public  boolean signUpUserLibrarian(){
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "insert into users (name,email,password,phone,userType_id,city_id) value (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4,phone);
            ps.setInt(5,userType.getUserTypeId());
            ps.setInt(6,city.getCityId());
            System.out.println(ps+"+++++++++++++++++++++++++++++++++++");
            int count = ps.executeUpdate();
            if(count==1){
                flag=true;
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    userId=rs.getInt(1);
                }
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        }
        return flag;
    }
//_____________________________________________________________________________________________________________________________________
    // public int signInUserLibrarian(){
    //     int statusId =0;
    //     //0 = account with email not exist.
    //     //1 = all ok.
    //     //2 = inactive.
    //     //3= closed.
    //     //4= blocked.
    //     //5= pending

    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
    //         String query = "select password,user_id,u.name,email,phone,address,c.city_id,c.name,s.status_id,t.userType_id"
    //         +" from users as u inner join cities as c inner join status as s inner join user_Types as t where u.city_id = c.city_id and u.status_id = s.status_id"
    //         +" and u.userType_id = t.userType_id"
    //         +" and email=?";

    //         PreparedStatement ps = con.prepareStatement(query);
    //         ps.setString(1, email);
        
    //         ResultSet rs = ps.executeQuery();

    //         if(rs.next()) {
    //             String pwd = rs.getString("password");
    //             System.out.println(pwd+"_________________Pwd");
    //             boolean passwordMatch = password.equals(pwd);
    //             System.out.println(passwordMatch);
    //             if(passwordMatch){
    //                 System.out.println("______________passwordMatch________________________________");
    //                 statusId = rs.getInt("status_id");
    //                 System.out.println(statusId+":::::::::::::::::::::::::::::::StatusId of Librarian");
    //                 if(statusId==1) {
    //                         userId = rs.getInt("user_id");
    //                         name = rs.getString("name");
    //                         email = rs.getString("email");
    //                         phone = rs.getString("phone");
    //                         address = rs.getString("address");
    //                         city = new City(rs.getInt("city_id"),rs.getString("name"));
    //                         userType = new UserType(rs.getInt("userType_id"));
    //                 }else{
    //                         statusId = -1;
    //                 }
    //             }
    //         }
    //     con.close();
    //     } catch (SQLException |ClassNotFoundException e) {
    //         e.printStackTrace();
    //     }
    //     return statusId;
    // }
 
//_____________________________________________________________________________________________________________________________________
    public boolean updateStatusId(String email){
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "update users  set status_id =1 where email=? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            int count = ps.executeUpdate();
            if(count==1){
                flag=true;
            }
            con.close();
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }
//_____________________________________________________________________________________________________________________________________
    public static boolean CheckEmailExist(String email){
        boolean flag= false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select * from users where email=?";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                flag=true;
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }
//____________________________________________________________________________________________________________

    public  static boolean checkEmailDuplicacy(String email){
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select user_id from users where email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                flag=true;
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;

    }
//___________________________________________________________________________________________________________


    public int signinuser(){
        int flag =0;
        //0 = account with email not exist.
        //1 = all ok.
        //2 = inactive.
        //3= closed.
        //4= blocked.
        //5= pending
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select user_id,u.name,email,password,phone,pic,address,c.city_id,c.name,s.status_id,t.userType_id"
            +" from users as u inner join cities as c inner join status as s inner join user_Types as t where u.city_id = c.city_id and u.status_id = s.status_id"
            +" and u.userType_id = t.userType_id"
            +" and email=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
        
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                flag = rs.getInt("status_id");
                if(flag==1){
                    if(spe.checkPassword(password, rs.getString("password"))){
                        password = null;
                        userId = rs.getInt("user_id");
                        name = rs.getString("name");
                        email = rs.getString("email");
                        phone = rs.getString("phone");
                        pic = rs.getString("pic");
                        address = rs.getString("address");
                        city = new City(rs.getInt("city_id"),rs.getString("name"));
                        userType = new UserType(rs.getInt("userType_id"));
                    }else{
                        flag = -1;
                    }

                }
            }

            con.close();

        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }

//_________________________________________________________________________________________________________________    

    public boolean signupuser(){
        boolean flag = false;
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "insert into users (name, email, password, phone, city_id, userType_id, otp) value (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, spe.encryptPassword(password));
            ps.setString(4, phone);
            ps.setInt(5, city.getCityId());
            ps.setInt(6, userType.getUserTypeId());
            ps.setString(7, otp);
        
            int count = ps.executeUpdate();

            if(count == 1)
                flag = true;
            
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        return flag;
    }
//____________________________________________________________________________________________________________    
    
    public static boolean verificationOfEmail(String email ,String vfcode){
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
        
            String query = "update users set status_id=1, otp='' where email=? and otp=?";
            PreparedStatement ps = con.prepareStatement(query);
        
            ps.setString(1, email);
            ps.setString(2, vfcode);

            int count = ps.executeUpdate();

            if(count==1){
                flag=true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }
    


// ______________________________________________________________________________________________________________
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity(){
        return city;
    }
    public void setCity(City city){
        this.city = city;
    }

    public String getOtp() {
        return otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    public UserType getUserType(){
        return userType;
    }
    
    public void setUserType(UserType userType){
        this.userType = userType;
    }

}