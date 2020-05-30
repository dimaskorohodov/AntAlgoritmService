package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class AntController {

//    @GetMapping("/solve")
//    public ModelAndView get(){
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.getModel().put("data","Some data from graf!!!");
//
//        return modelAndView;
//    }

//    @GetMapping("/solve")
//    public void get(){
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.getModel().put("data","Some data from graf!!!");
//
//        so
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createAction() {

        return Optional.ofNullable("Lol").map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


}
