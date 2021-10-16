package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.List;

import javax.validation.Valid;

import model.Books;
import repository.BookRepository;


@Controller
@RequestMapping("/BookStore/")
public class BooksController {

    
    private BookRepository bookRepository;

    @Autowired
    public BooksController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;

    }

    @GetMapping("signup")
    public String showSignUpForm(Books book) {
        System.out.println("entered signup ");
        return "Input";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        System.out.println("entered ");
        model.addAttribute("Books", bookRepository.findAll());
        return "display";
    }

    @PostMapping("add")
    public String addStudent(@Valid Books book, BindingResult result, Model model) {
        System.out.println("entered ");
        if (result.hasErrors()) {
            return "Input";
        }

        bookRepository.save(book);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        System.out.println("entered ");
        Books book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Book Id:" + id));
        model.addAttribute("book", book);
        return "update";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Books book, BindingResult result,Model model) 
    {
        System.out.println("entered ");
        if (result.hasErrors()) {
            book.setBcode(id);
            return "update";
        }

        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "display";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        System.out.println("entered ");
        Books book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        bookRepository.delete(book);
        model.addAttribute("books", bookRepository.findAll());
        return "display";
    }

    
    


    
}
