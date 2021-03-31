package de.telran.helloweb.controller;

import de.telran.helloweb.dto.Auto;
import de.telran.helloweb.dto.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model) {
        String capital = name.substring(0, 1).toUpperCase() + name.substring(1);
        model.addAttribute("bigLetters", capital);
        return "hello";
    }

    @RequestMapping(value = "/hello-bare/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloString(@PathVariable String name) {
        String capital = name.substring(0, 1).toLowerCase() + name.substring(1);
        return "Hello " + capital + "!";
    }

    @RequestMapping(value = "/hello-json/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Greeting helloJson(@PathVariable String name) {
        String capital = name.substring(0, 1).toLowerCase() + name.substring(1);
        Greeting response = new Greeting(capital, "bonjour");
        return response;
    }

    @RequestMapping(value = "/hello-json-to-string/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloJsonToString(@PathVariable String name) {
        String capital = name.substring(0, 1).toLowerCase() + name.substring(1);
        Greeting response = new Greeting(capital, "bonjour");
        return response.toString();
    }

    @PostMapping("/auto")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String acceptAuto(@RequestBody Auto auto) {
        System.out.println(auto);
        return "the following auto was received "
                + "make " + auto.make + ", color " + auto.color;
    }


    //TODO write endpoints with types PUT PATCH DELETE and check with TalendAPI

    @PutMapping("/auto")
    @ResponseBody
    public String updateAuto(@RequestBody Auto auto) {
        System.out.println(auto);
        return "the following auto was received "
                + "make " + auto.make + ", color " + auto.color;
    }

    @PatchMapping("/auto")
    @ResponseBody
    public String updateAutoPatch(@RequestBody Auto auto) {
        System.out.println(auto);
        return "the following auto was received "
                + "make " + auto.make + ", color " + auto.color;
    }

    @DeleteMapping("/auto")
    @ResponseBody
    public String deleteAuto() {
        String response = "successfully deleted";
        return response;
    }
}
