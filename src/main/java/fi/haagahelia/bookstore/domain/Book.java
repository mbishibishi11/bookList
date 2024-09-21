package fi.haagahelia.bookstore.domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private long id;
    private String title, author, isbn, price;
    private Integer publishYear;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Bookcategory bookcategory;

    public Book() {}

    public Book(String title, String author, String isbn, String price, Integer publishYear, Bookcategory bookcategory) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.publishYear = publishYear;
        this.bookcategory = bookcategory;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Integer getPublishYear() {
        return publishYear;
    }
    public void setpublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Bookcategory getBookcategory() {
        return bookcategory;
    }

    public void setBookcategory(Bookcategory bookcategory) {
        this.bookcategory = bookcategory;
    }

    
}
