package controller;

import repository.UserRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.joran.conditional.ElseAction;

import org.springframework.ui.Model;
import java.util.*;

import model.User;
 
@Controller
@RequestMapping()

public class AppController {

    @Autowired
    private UserRepository userRepo;

    public AppController(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }
     
    @GetMapping("")
    public String viewHomePage(User user) {
        
        return "index";
    }

    @GetMapping("/Sign_up/loginpage")
    public String goToLogin()
    {
        return "login";
    }

    @PostMapping("/Sign_up/save")
    public String saveUser(@Valid User user,BindingResult result){

        if(result.hasErrors())
        {
            return "index";
        }
        
        userRepo.save(user);


        return "login";        


    }

    @GetMapping("/Sign_up/login")
    public String loginUser(@RequestParam("email") String email,@RequestParam("password") String password)
    {
        List<User> userlist = userRepo.findByEmailAndPassword(email,password);
        if(userlist.size()>0)
        {
            System.out.println("Login SuccessFul");
            return "landing";
        }
        else{
            System.out.println("Incorrect Username Or PassWord");
        }

        return "login";

        
    }

    
}
