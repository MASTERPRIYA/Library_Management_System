package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Category {
    private Integer categoryId;
    private String type;

    public Category(Integer categoryId,String type){
        this.categoryId = categoryId;
        this.type = type;
    }  

    public Category(Integer categoryId){
        this.categoryId = categoryId;
       
    }  
//------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Category> collectAllCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select * from categories";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt(1),rs.getString(2)));
            }
            con.close();
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categories;
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
