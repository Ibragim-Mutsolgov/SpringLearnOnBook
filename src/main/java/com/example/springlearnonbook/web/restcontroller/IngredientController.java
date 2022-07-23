package com.example.springlearnonbook.web.restcontroller;

import com.example.springlearnonbook.domain.Ingredient;
import com.example.springlearnonbook.web.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:8087")
@RequestMapping(value = "/api/ingredients", consumes = "application/json")
public class IngredientController {

    private IngredientRepository ingredientRepository;

    @GetMapping
    public Iterable<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> findById(@PathVariable("id") String id){
        return ingredientRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient save(@RequestBody Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void delete(@PathVariable("id") String id){
        ingredientRepository.deleteById(id);
    }
}
