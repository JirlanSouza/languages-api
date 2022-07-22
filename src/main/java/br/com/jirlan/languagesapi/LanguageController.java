package br.com.jirlan.languagesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LanguageController {
    @Autowired
    private LanguageRepository repository;
    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return this.repository.findAll();
    }

    @PostMapping("/languages")
    @ResponseStatus(HttpStatus.CREATED)
    public Language registerLanguage(@RequestBody Language language) {
        return this.repository.save(language);
    }

    @DeleteMapping("/languages/{languageId}")
    public Language removeLanguage(@PathVariable String languageId) {
        var language = this.repository.findById(languageId);

        if (language.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Language not found");
        }
        this.repository.delete(language.get());

        return language.get();
    }
}

