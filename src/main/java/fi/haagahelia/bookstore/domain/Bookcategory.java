package fi.haagahelia.bookstore.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Bookcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookcategory")
    private List<Book> books;

    public Bookcategory() {}

    public Bookcategory(String name) {
        super();
        this.name = name;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }
    
    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category [categoryid=]" + categoryid + ", name=" + name + "]"; 
    }
}
