package com.omid.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;


@Controller

public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getThis(HttpServletRequest request) {
        return "index";
    }
}
