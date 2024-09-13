package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (args) -> {
			Book book1 = new Book("Kasvoton kuolema", "Hennig Mankell", "1223", "12.0", 1989);
			Book book2 = new Book("Riian verikoirat", "Hennig Mankell", "1234", "13.0", 1990);

			repository.save(book1);
			repository.save(book2);
		};
	}
}
