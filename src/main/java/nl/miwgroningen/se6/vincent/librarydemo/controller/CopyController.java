package nl.miwgroningen.se6.vincent.librarydemo.controller;

import nl.miwgroningen.se6.vincent.librarydemo.model.Book;
import nl.miwgroningen.se6.vincent.librarydemo.model.Copy;
import nl.miwgroningen.se6.vincent.librarydemo.repository.BookRepository;
import nl.miwgroningen.se6.vincent.librarydemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Endpoints for buying, loaning and returning copies
 */

@Controller
@RequestMapping("/copies")
public class CopyController {

    private BookRepository bookRepository;
    private CopyRepository copyRepository;

    public CopyController(BookRepository bookRepository, CopyRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }

    @GetMapping("/new/{bookId}")
    protected String createNewCopy(@PathVariable("bookId") Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) {
            return "redirect:/books";
        }
        copyRepository.save(new Copy(book.get()));
        return "redirect:/books";
    }
}
