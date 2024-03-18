package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Candidate extends User {
    private Integer candidateId;
    private String organization;
    private String dob;
    private String gender;
    private String adhaarcard;
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

public Candidate(String email, String password) { 
    super(email, password);
}
public Candidate(String name, String email, String password, City city, UserType userType, String gender, String organization, String adhaarcard, String dob, String phone, String address, String otp) {
        super(name,email,password,city,userType,phone,address,otp);
        this.gender=gender;
        this.organization=organization;
        this.adhaarcard=adhaarcard;
        this.dob=dob;
    }

    public Candidate(int candidateId){
        this.candidateId = candidateId;
    }

    public Candidate(){
        
    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public int signInUserCandidate(){
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
        String query = "select u.user_id,u.name,u.email,u.password,c.city_id,t.userType_id,phone,address,s.status_id,candidate_id,organization,gender,adhaarcard "
        +" from users as u inner join cities as c inner join user_Types as t inner join status as s inner join candidates as cn where u.city_id=c.city_id and"
        +" u.status_id = s.status_id and u.userType_id=t.userType_id and u.user_id=cn.user_id  and email=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, getEmail());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String pwd = rs.getString("password");
            System.out.println(pwd+"+++++++");
            boolean passwordMatch = getPassword().equals(pwd);
            System.out.println(passwordMatch);
            if(passwordMatch){
                System.out.println("Password Match Candidate");
                statusId= rs.getInt("status_id");
                System.out.println(statusId+"------Candidate StatusId");
                if(statusId==1){
                    setUserId(rs.getInt("user_id"));
                    setName(rs.getString("name"));
                    setEmail(rs.getString("email"));
                    setPassword(rs.getString("password"));
                    setCity(new City(rs.getInt("city_id"), rs.getString("name")));
                    setUserType(new UserType(rs.getInt("userType_id")));
                    setPhone (rs.getString("phone"));
                    setAddress(rs.getString("address"));
                    candidateId = rs.getInt("candidate_id");
                    organization = rs.getString("organization");
                    gender = rs.getString("gender");
                    adhaarcard = rs.getString("adhaarcard");
                }else{
                    statusId=-1;
                }
            }
        }
    con.close();    
    } catch (SQLException|ClassNotFoundException e) {
        e.printStackTrace();
    }
    return statusId;
}
//____________________________________________________________________________________________________________________________________________________


    public boolean signUpCandidate(){
        boolean flag=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "insert into candidates(user_id,organization,dob,gender,adhaarcard) value (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,getUserId());
            ps.setString(2,organization);
            ps.setDate(3, java.sql.Date.valueOf(dob));
            ps.setString(4,gender);
            ps.setString(5,adhaarcard);
            System.out.println(ps+"______________________SignUpCandidate_____________________________");
            int count=ps.executeUpdate();
            if(count==1){
                flag=true;
            }
            con.close();
        } catch (SQLException|ClassNotFoundException e) {
                e.printStackTrace();
        }
        return flag;
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
    public void getCandidateDetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select c.candidate_id,organization,dob,gender,adhaarcard,u.user_id,u.name,"
            +" u.email,u.phone,u.address,c.city_id,ut.userType_id from candidates as c inner join users as u"
            +" inner join cities as c inner join user_Types as ut where c.user_id=u.user_id and u.userType_id=ut.userType_id and u.city_id = c.city_id and u.userType_id=3 and candidate_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println(ps+"============Candidate Details");
            ps.setInt(1, candidateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                candidateId = rs.getInt(1);
                organization = rs.getString(2);
                dob=rs.getString(3);
                gender= rs.getString(4);
                adhaarcard= rs.getString(5);
                setUserId(rs.getInt(6));
                setName(rs.getString(7));
                setEmail(rs.getString(8));
                setPhone(rs.getString(9));
                setAddress(rs.getString(10));
                setCity(new City(rs.getInt(11)));
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 

    
    public Integer getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getorganization() {
        return organization;
    }
    public void setorganization(String organization) {
        this.organization = organization;
    }


    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getadhaarcard(){
        return adhaarcard;
    }
    public void setadhaarcard(String adhaarcard){
        this.adhaarcard = adhaarcard;
    }
    
}
