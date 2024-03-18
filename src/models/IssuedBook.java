package models;

import java.util.Date;

public class IssuedBook {
    private Integer issuedBookId;
    private Membership membership;
    private Date issuedOn;
    private Date expectedReturnDate;
    private Date actualReturnDate;
    private Integer fine;
    private LibraryBook libraryBook;


    
    public Integer getIssuedBookId() {
        return issuedBookId;
    }
    public void setIssuedBookId(Integer issuedBookId) {
        this.issuedBookId = issuedBookId;
    }

    public Membership getMembership() {
        return membership;
    }
    public void setMembership(Membership membership) {
        this.membership = membership;
    }
    
    public Date getIssuedOn() {
        return issuedOn;
    }
    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }

    public Date getExpectedReturnedDate() {
        return expectedReturnDate;
    }
    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }
    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public Integer getFine() {
        return fine;
    }
    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public LibraryBook getLibraryBook() {
        return libraryBook;
    }
    public void setLibraryBook(LibraryBook libraryBook) {
        this.libraryBook = libraryBook;
    }

    

    
}
