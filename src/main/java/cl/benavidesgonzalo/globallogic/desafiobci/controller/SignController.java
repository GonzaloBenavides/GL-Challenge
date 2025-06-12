package cl.benavidesgonzalo.globallogic.desafiobci.controller;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cl.benavidesgonzalo.globallogic.desafiobci.model.Error;
import cl.benavidesgonzalo.globallogic.desafiobci.model.User;
import cl.benavidesgonzalo.globallogic.desafiobci.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SignController {

    public Pattern mailRegex = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    public Pattern passRegex = Pattern.compile("^(?=(.*\\d){2})(?=(.*[A-Z]){1}).{8,12}$");

    @Autowired
    UserService service;

    @RequestMapping(path = "/sign-up", method=RequestMethod.POST)
    public ResponseEntity<Object> sign(@RequestParam User user) {
        String errorDetail = "";

        Matcher mailMatcher = mailRegex.matcher(user.getEmail());
        Matcher passMatcher = passRegex.matcher(user.getPassword());
        
        if(mailMatcher.matches())
            System.out.println("mail matches!");
        else
            errorDetail += "Invalid mail format. ";

        if(passMatcher.matches())
            System.out.println("pass matches!");
        else
            errorDetail += "Invalid password format. ";

        if(!errorDetail.isEmpty()){
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(), errorDetail, new Date()), HttpStatus.BAD_REQUEST);
        }

        try{
            User newUser = service.addUser(user);        

            if(newUser == null){
                errorDetail += "User already exists. ";
                return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(), errorDetail, new Date()), HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);

        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
