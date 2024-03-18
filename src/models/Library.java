package models;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;


public class Library {
    private Integer libraryId;
    private User user;
   
    

//_______________________________________________Constructor____________________________________________________ 


    
//_______________________________________________Methods_______________________________________________________



//__________________________________________________Getter-Setter_______________________________________________ 
    public Integer getLibraryId() {
        return libraryId;
    }
    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
