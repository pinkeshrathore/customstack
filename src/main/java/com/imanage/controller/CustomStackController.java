package com.imanage.controller;

import com.imanage.exception.EmptyStackException;
import com.imanage.exception.FullStackException;
import com.imanage.exception.StackAlreadyPresentException;
import com.imanage.model.StackInput;
import com.imanage.service.CustomStackImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomStackController {

    @Value("${spring.application.size}")
    private int defaultSize;

    @Autowired
    private CustomStackImpl customStack;


    @RequestMapping(method = RequestMethod.POST, path = "/createstack")
    public ResponseEntity<String> createStack(@RequestBody StackInput stackInput) {
        customStack.createStack(stackInput.getSize() > -1 ? stackInput.getSize() : defaultSize);
        return new ResponseEntity<String>("Stack of created successully!", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/push")
    public ResponseEntity<String> push(@RequestBody StackInput stackInput) {
        customStack.push(stackInput.getValue());
        return new ResponseEntity<String>("Item pushed successully!", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/pop")
    public ResponseEntity<String> pop() {
        return new ResponseEntity<String>("Element popped : " + customStack.pop(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/peek")
    public ResponseEntity<String> peek() {
        return new ResponseEntity<String>("Top element : " + customStack.peek(), HttpStatus.OK);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(){
        return new ResponseEntity<String>("Please create stack!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyStackException.class)
    public ResponseEntity<String> handleEmptyStackException(){
        return new ResponseEntity<String>("Stack is empty!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FullStackException.class)
    public ResponseEntity<String> handleFullStackException(){
        return new ResponseEntity<String>("Stack is full!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StackAlreadyPresentException.class)
    public ResponseEntity<String> handleStackAlreadyPresentException(){
        return new ResponseEntity<String>("Stack is already created!", HttpStatus.BAD_REQUEST);
    }

}
