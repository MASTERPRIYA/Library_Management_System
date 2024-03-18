package models;

import java.sql.*;
import java.util.ArrayList;

public class Book {
    private Integer bookId;
    private String name;
    private String author;
    private Category category;
    private String about;
//====================================================================================

    public Book(String name,String author,Category category,String about){
    
        this.name=name;
        this.author=author;
        this.category=category;
        this.about=about;
    }

    // public Book(Integer bookId,String name,String author,Category category,String about){
        
    //     this.bookId=bookId;
    //     this.name=name;
    //     this.author=author;
    //     this.category=category;
    //     this.about=about;
    // }

    public Book(){

    }

//====================================================================================
    public boolean addBook(){
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
            String query = "insert into books (name,author,category_id,about) value (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
           // ps.setInt(1,getEditionId());
            ps.setString(1,name);
            ps.setString(2,author);
            ps.setInt(3,category.getCategoryId());
            ps.setString(4, about);
            System.out.println(ps);
            int count = ps.executeUpdate();
            if(count ==1){
                flag= true;
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    bookId=rs.getInt(1);
                }
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }

        return flag;
    }
//=======================================================================================  
    // public static ArrayList<Book> collectAllBooks(){
    //     ArrayList<Book> books = new ArrayList<>();
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?user=root&password=1234");
    //         String query = "select b.book_id,name,author,c.category_id,p.publisher_id,about,e.edition_id,e.editions,price,ISBN,date,weights,pages"+
    //         " from books as b inner join categories as c inner join publishers as p inner join editions as e where b.book_id=e.book_id"+
    //         " and b.category_id = c.category_id and b.publisher_id = p.publisher_id";
    //         PreparedStatement ps = con.prepareStatement(query);
    //         ResultSet rs = ps.executeQuery();
    //         System.out.println(ps+"-----------Collect All Books------------------------------");
    //         while(rs.next()){
    //             Book book = new Book();
    //             book.bookId = rs.getInt(1);
    //             book.name = rs.getString(2);
    //             book.author = rs.getString(3);
    //             book.setCategory(new Category(rs.getInt(4)));
    //             book.setPublisher(new Publisher(rs.getInt(5)));
    //             book.about = rs.getString(6);
    //             book.setEditionId(rs.getInt(7));
    //             book.setEditions(rs.getString(8));
    //             book.setQuantity(rs.getInt(9));
    //             book.setPrice(rs.getInt(10));
    //             book.setISBN(rs.getString(11));
    //             book.setdate(rs.getString(12));
    //             book.setWeights(rs.getFloat(13));
    //             book.setPages(rs.getInt(14));
    //             books.add(book);
    //         }
    //         con.close();
    //     } catch (SQLException | ClassNotFoundException e) {
    //        e.printStackTrace();
    //     }
    //     return books;
    // }
//=======================================================================================    
    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getAbout(){
        return about;
    }
    public void setAbout(String about){
        this.about=about;
    } 
    
}
