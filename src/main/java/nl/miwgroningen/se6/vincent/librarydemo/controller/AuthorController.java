package nl.miwgroningen.se6.vincent.librarydemo.controller;

import nl.miwgroningen.se6.vincent.librarydemo.model.Author;
import nl.miwgroningen.se6.vincent.librarydemo.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Alle paginas met auteurs
 */

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    protected String showAuthorOverview(Model model) {
        model.addAttribute("allAuthors", authorRepository.findAll());
        model.addAttribute("newAuthor", new Author());
        return "authorOverview";
    }

    @GetMapping("/authors/detail/{authorId}")
    protected String showAuthorDetails(@PathVariable("authorId") Integer authorId, Model model) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            model.addAttribute("author", author.get());
            return "authorDetails";
        }
        return "redirect:/authors";
    }

    @PostMapping("/authors/new")
    protected String saveOrUpdateAuthor(@ModelAttribute("newAuthor") Author author, BindingResult result) {
        if (!result.hasErrors()) {
            authorRepository.save(author);
            return "redirect:/authors";
        } else {
            return "authorOverview";
        }
    }
}
