package com.martin.personality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/martin/personalities")
@CrossOrigin(origins = "*")
public class PersonalityController {

    private final PersonalityRepository repository;

    @Autowired
    public PersonalityController(PersonalityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Personality> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Personality create(@RequestBody Personality p) {
        return repository.save(p);
    }

    @PostMapping("/bulk")
    public List<Personality> saveBulk(@RequestBody List<Personality> personalities) {
        return repository.saveAll(personalities);
    }
}
