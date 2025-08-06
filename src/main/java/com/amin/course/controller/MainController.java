package com.amin.course.controller;

import com.amin.course.entity.Cat;
import com.amin.course.repository.CatRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CatRepo catRepo;
    @GetMapping("/api/main")
    public String mainListiner(){
        return "Hello World";
    }

    @GetMapping("/api/cat")
    public String giveCat(){
        Cat cat = new Cat("Barsik", 5, "orange");

        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        }catch (JsonProcessingException e){
            System.out.println("Не удалось добавить кота " + e.getMessage());
        }
        return  jsonData;
    }
    @PostMapping("/api/special")
    public String getSpecialCat(@RequestParam String name){
        Cat cat = new Cat(name, 5, "orange");

        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        }catch (JsonProcessingException e){
            System.out.println("Не удалось добавить кота " + e.getMessage());
        }
        return  jsonData;
    }
    @PostMapping("/api/cats")
    public ResponseEntity<String> saveCat(@RequestBody Cat cat) {
        try {
            Cat savedCat = catRepo.save(cat);
            String jsonResponse = objectMapper.writeValueAsString(savedCat);
            return ResponseEntity.ok(jsonResponse);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при обработке данных кота");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Не удалось сохранить кота: " + e.getMessage());
        }
    }
}

