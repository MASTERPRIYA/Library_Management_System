package models;

public class LibraryBook {
    private Integer libraryBookId;
    private Library library;
    private Edition edition;
    private Integer copies;



    
    public Integer getLibraryBookId() {
        return libraryBookId;
    }
    public void setLibrarybookId(Integer libraryBookId) {
        this.libraryBookId = libraryBookId;
    }

    public Library getLibrary() {
        return library;
    }
    public void setLibray(Library library) {
        this.library = library;
    }

    public Edition getEdition() {
        return edition;
    }
    public void setEdition(Edition edition) {
        this.edition = edition;
    }
    
    public Integer getCopies() {
        return copies;
    }
    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    
    
}
