package controller;

import repository.UserRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import model.User;
 
@Controller
@RequestMapping("/Sign_up")

public class AppController {

    @Autowired
    private UserRepository userRepo;

    public AppController(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }
     
    @GetMapping("/entry")
    public String viewHomePage(User user) {
        
        return "signup";
    }

    @PostMapping("/save")
    public String saveUser(@Valid User user,BindingResult result){

        if(result.hasErrors())
        {
            return "signup";
        }
        
        userRepo.save(user);


        return "index";        


    }

    
}
