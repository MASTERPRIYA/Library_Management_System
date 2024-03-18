package models;

import java.util.ArrayList;
import java.sql.*;


public class Edition extends Book {
    private Integer editionId;
    //private Book books;
    private String editions;
    private Integer quantity;
    private Integer price;
    private String ISBN;
    private String date;
    private Float weights;
    private Integer pages;
//=========================================================================================
    public Edition(String editions,Integer quantity,Integer price,String ISBN,String date,Float weights,Integer pages,String name,String author,Category category,String about){
       super(name,author,category,about);
        this.editions= editions;
        this.quantity=quantity;
        this.price = price;
        this.ISBN=ISBN;
        this.date = date;
        this.weights =weights;
        this.pages=pages;
   
    }

    public Edition(){

    }
    //=======================================================================================
    public boolean addBookEdition(){
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "insert into editions (book_id,editions,quantity,price,ISBN,date,weights,pages) value (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, getBookId());
            ps.setString(2,editions);
            ps.setInt(3, quantity);
            ps.setInt(4, price);
            ps.setString(5,ISBN);
            ps.setDate(6,java.sql.Date.valueOf(date));
            // java.util.String String = new java.util.String();
            // java.sql.String String = new java.sql.String(String.getTime());
            // ps.setString(6, String);
            ps.setFloat(7,weights);
            ps.setInt(8,pages);
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
//=======================================================================
    public static ArrayList<Edition> collectAllEditions(){
        ArrayList<Edition> editionBook = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select edition_id,editions,quantity,price,ISBN,date,weights,pages,b.book_id,b.name,b.author,c.category_id,about"+
            " from editions as e inner join books as b inner join categories as c where e.book_id=b.book_id and b.category_id=c.category_id";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println(ps+"_____________Collect All Edition");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Edition edition = new Edition();
                edition.editionId=rs.getInt(1);
                edition.editions=rs.getString(2);
                edition.quantity=rs.getInt(3);
                edition.price=rs.getInt(4);
                edition.ISBN=rs.getString(5);
                edition.date=rs.getString(6);
                edition.weights=rs.getFloat(7);
                edition.pages=rs.getInt(8);
                edition.setBookId(rs.getInt(9));
                edition.setName(rs.getString(10));
                edition.setAuthor(rs.getString(11));
                edition.setCategory(new Category(rs.getInt(12)));
                edition.setAbout(rs.getString(13));
                editionBook.add(edition);

            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return editionBook;
    }
//================================================================ ===========
    public void getBookDetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "select edition_id,editions,quantity,price,ISBN,date,weights,pages,b.book_id,b.name,b.author,c.category_id,about"+
            " from editions as e inner join books as b inner join categories as c where e.book_id=b.book_id and b.category_id=c.category_id and edition_id=? ";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println(ps+"---------------------------------------Details of Books");
            ps.setInt(1, editionId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             //  Edition edition = new Edition();
                editionId=rs.getInt(1);
               editions=rs.getString(2);
                quantity=rs.getInt(3);
               price=rs.getInt(4);
               ISBN=rs.getString(5);
               date=rs.getString(6);
              weights=rs.getFloat(7);
                pages=rs.getInt(8);
               setBookId(rs.getInt(9));
                setName(rs.getString(10));
              setAuthor(rs.getString(11));
                setCategory(new Category(rs.getInt(12)));
               setAbout(rs.getString(13));
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//================================================================ ===========
    public Integer getEditionId() {
        return editionId;
    }
    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer quantity){
        this.quantity=quantity;
    }
   
    public String getEditions(){
        return editions;
    }
    public void setEditions(String editions){
        this.editions = editions;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getString() {
        return date;
    }
    public void setString(String date) {
        this.date = date;
    }

    public Float getWeights() {
        return weights;
    }
    public void setWeights(Float weights) {
        this.weights = weights;
    }
    
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }  
    
}
