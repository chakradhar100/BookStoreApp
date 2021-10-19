package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.data.domain.Sort;
import java.util.List;

import javax.validation.Valid;

import model.Books;
import repository.BookRepository;


@Controller
@RequestMapping("/BookStore")
public class BooksController {

    
    private final BookRepository bookRepository;

    @Autowired
    public BooksController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;

    }

    @GetMapping("/signup")
    public String showSignUpForm(Books book) {
        System.out.println("entered signup ");
        return "add-book";
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        System.out.println("entered Display");
        model.addAttribute("Books1", bookRepository.findAll());
        return "display-book";
    }

    @PostMapping("/add")
    public String addStudent(@Valid Books book, BindingResult result, Model model) {
        System.out.println("entered Add");
        if (result.hasErrors()) {
            return "add-book";
        }

        bookRepository.save(book);
        return "redirect:list";
    }

    @GetMapping("/sort")
    public String sortBy(@RequestParam("sort")String  colname, Model model)
    {
        System.out.println("entered sort operation");
        List<Books> booklist = bookRepository.findAll(Sort.by(Sort.Direction.ASC,colname));
        model.addAttribute("Books1", booklist);


        return "display-book";
    }

    @GetMapping("/search")
    public String searchBy(@RequestParam("book")String book, Model model)
    {
        System.out.println("entered Search Operation");
        System.out.println(book);
        List<Books> booklist = bookRepository.findByBnameIgnoreCase(book);
        model.addAttribute("Books1", booklist);
        return "display-book";
    }

    

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id,Books book1, Model model) {
        System.out.println("entered edit ");
        Books book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Book Id:" + id));
        model.addAttribute("book", book);
        bookRepository.delete(book);
        return "update-book";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Books book, BindingResult result,Model model) 
    {
        System.out.println("entered update ");
        if (result.hasErrors()) {
            book.setBcode(id);
            return "update-book";
        }

        book.setBcode(id);
        bookRepository.save(book);
        return "redirect:/BookStore/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        System.out.println("entered  delete");
        Books book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        bookRepository.delete(book);
        
        return "redirect:/BookStore/list";
    }

    
    


    
}
