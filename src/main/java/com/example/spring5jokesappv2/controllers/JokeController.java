package com.example.spring5jokesappv2.controllers;

import com.example.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    // DI of a JokeService !
    // Note that for this stile of DI (constructor based), annotation is optional
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    // Spring MVC!  This will handle specified requests.
    // Input Model is a map (to which we can add pairs).
    // Return value is the view to be displayed.
    @RequestMapping({"/", "", "/index.html", "index"})
    public String showJoke(Model model) {

        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
