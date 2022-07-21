package br.com.jirlan.languagesapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    @GetMapping("/favorate-language")
    public Hello home() {
        return new Hello("Hello, Java!");
    }
}

record Hello (String message) {}
