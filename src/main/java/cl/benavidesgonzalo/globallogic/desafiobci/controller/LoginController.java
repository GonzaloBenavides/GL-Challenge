package cl.benavidesgonzalo.globallogic.desafiobci.controller;

import org.springframework.web.bind.annotation.RestController;

import cl.benavidesgonzalo.globallogic.desafiobci.model.Error;
import cl.benavidesgonzalo.globallogic.desafiobci.model.User;
import cl.benavidesgonzalo.globallogic.desafiobci.service.UserService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LoginController {

    @Autowired
    UserService service;

    @RequestMapping(path = "/login", method=RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestParam String token) {
        try{
            User tokenUser = service.findUserByToken(token);

            if(tokenUser == null){
                String errorDetail = "Invalid token. ";
                return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(), errorDetail, new Date()), HttpStatus.BAD_REQUEST);
            }
            else{
                return new ResponseEntity<>(tokenUser, HttpStatus.CREATED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
