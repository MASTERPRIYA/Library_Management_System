package models;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class Membership {
    private Integer membershipId;
    //private Library library;
    private Candidate candidate;
    private Timestamp dateOfJoin;
    private MembershipType membershipType;
    private Integer deposit;
    private Status status;


// -------------------------------------------------------------------------------------------------------------------------------------------
    public Membership(Candidate candidate,Timestamp dateOfJoin,MembershipType membershipType,int deposit,Status status){
        this.candidate = candidate;
        this.dateOfJoin=dateOfJoin;
        this.membershipType=membershipType;
        this.deposit=deposit;
        this.status=status;
    }
    public Membership(){

    }

//---------------------------------------------------------------------------------------------------------------------------------------------------
    public int memberShip(String email){
      int statusId =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select c.candidate_id,m.date_of_join,m.deposit,s.status_id from candidate as c inner join"
            +" status as s inner join memberships as m where m.candidate_id=c.candidate_id and m.status_id = 1 and email=? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs  = ps.executeQuery();
            if (rs.next()) {
                
                    candidate = new Candidate(rs.getInt("candidate_id"));
                    dateOfJoin = rs.getTimestamp("date_of_join");
                    deposit = rs.getInt("deposit");
                
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }
        return statusId;
    }    
//-----------------------------------------------------------------------------------------------------------------------------------------
    
    public Integer getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    // public Library getLibrary() {
    //     return library;
    // }
    // public void setLibrary(Library library) {
    //     this.library = library;
    // }

    public Candidate getCandidate() {
        return candidate;
    }
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Timestamp getDateOfJoin() {
        return dateOfJoin;
    }
    public void setDateOfJoin(Timestamp dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }
    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Integer getDeposit() {
        return deposit;
    }
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }
    
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    
    
}
