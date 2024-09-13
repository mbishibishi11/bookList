package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping("/bookstore")
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "bookstore";
    }
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../bookstore";
    }
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:bookstore";
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId,Model model) {
        Book book = repository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid Book Id"));
        model.addAttribute("book", book);
        return "editbook";
    }
    @RequestMapping(value = "/saveEdit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {

        Book existingBook = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Book Id"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());
        existingBook.setpublishYear(book.getPublishYear());

        repository.save(existingBook);
        return "redirect:/bookstore";
    }

    
    
}
