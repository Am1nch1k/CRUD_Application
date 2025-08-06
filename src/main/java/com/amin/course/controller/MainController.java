package com.amin.course.controller;

import com.amin.course.entity.Cat;
import com.amin.course.repository.CatRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CatRepo catRepo;
    public final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void  addCat(@RequestBody Cat cat){
        log.info("New row: " +catRepo.save(cat));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAll() {
        return catRepo.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }

    @PutMapping("/api")
    public void updateCat(@RequestBody Cat cat) {
        catRepo.save(cat);
    }

}


