package fi.haagahelia.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Bookcategory;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository srepository){
		return (args) -> {
			log.info("save a couple of books");

			Bookcategory bookcategory1 = new Bookcategory("Science");
			Bookcategory bookcategory2 = new Bookcategory("Fiction");
			Bookcategory bookcategory3 = new Bookcategory("Biography");

			srepository.save(bookcategory1);
			srepository.save(bookcategory2);
			srepository.save(bookcategory3);

			repository.save(new Book("Kasvoton kuolema", "Hennig Mankell", "1223", "12.0", 1989, bookcategory1));
			repository.save(new Book("Riian verikoirat", "Hennig Mankell", "1234", "13.0", 1990, bookcategory2));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
