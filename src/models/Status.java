package models;

import java.util.ArrayList;
import java.sql.*;

public class Status {
    private Integer statusId;
    private String type;

    public static final Status ACTIVE = new Status(1,"Active");
    public static final Status INACTIVE = new Status(2,"Inactive");
    public static final Status CLOSED = new Status(3, "Closed");
    public static final Status BLOCKED = new Status(4, "Blocked");
    public static final Status PENDING = new Status(5, "Pending");


//--------------------------------------------------------------------------------------------------
    public Status(Integer statusId , String type){
        this.statusId = statusId;
        this.type = type;
    }
//------------------------------------------------------------------------------------------------------
    public static ArrayList<Status> collectAllStatus() {
        ArrayList<Status> status = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select * from status";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                status.add(new Status(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            
        }
        return status;

    } 
//-------------------------------------------------------------------------------------------------------

    public Integer getStatusId() {
        return statusId;
    }
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    
    
}
